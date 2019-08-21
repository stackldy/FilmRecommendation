import math
import sys

import pymysql

from pyspark import SparkConf, SparkContext

#数据库参数声明
url="rm-m5e8tlshx46qfd4m3jo.mysql.rds.aliyuncs.com"
username="ldy"
passwd="135135LDYldy"
dbname="movie"

#声明spark应用
def CreatSparkContext():
    sparkConf=SparkConf().setAppName("itemcfrecommend").set("spark.ui.showConsoleProgress","false")
    sc=SparkContext(conf=sparkConf)
    print("master="+sc.master)
    SetLogger(sc)
    SetPath(sc)
    return sc

def SetLogger(sc):
    logger=sc._jvm.org.apache.log4j
    logger.LogManager.getLogger("org").setLevel(logger.Level.ERROR)
    logger.LogManager.getLogger("akka").setLevel(logger.Level.ERROR)
    logger.LogManager.getRootLogger().setLevel(logger.Level.ERROR)

#数据来源路径
def SetPath(sc):
    global Path
    global OutPath
    if sc.master[0:5]=="local":
        Path="file:/home/ldy/ALS/input/"
        OutPath="file:/home/ldy/ALS/output/"
    else:
        Path="hdfs://localhost:9000/movie/input/"
        OutPath="hdfs://localhost:9000/movie/output/"

#初始化数据
def prepardata(sc,Path):
    rawUserData=sc.textFile(Path)
    rawRatings=rawUserData.map(lambda line:line.split(",")[:2])
    ratingsRDD=rawRatings.map(lambda x:(x[0],x[1]))
    return ratingsRDD

#物品相似度矩阵
def calculate(x1,x2):
    count1=[ ]
    count2=[ ]
    for x in x1:
        count1.append(x)
    for x in x2:
        count2.append(x)
    count=len(count1)*len(count2)*1.0
    a=set(count1)
    b=set(count2)
    c=a&b
    bothcount=len(c)
    w=bothcount/math.sqrt(count)
    return w

def find(x,item):
    if item==x:
        return True
    return False

def get(x,k):
    x.sort(key=lambda x:x[1],reverse=True)
    return x[:k]

#推荐物品
def recommenditem(itemlist,k):
    for item in itemlist:
       sim_item=W.filter(lambda x:find(x[0],item)).map(lambda x:x[1])
       recommend_item=sim_item.flatMap(lambda x:get(x,k)).reduceByKey(lambda x,y:x+y)
       recommend_item=recommend_item.sortBy(lambda x:x[1],False)
       recommend_item=recommend_item.take(k)
       print(recommend_item)
       savedata(item,recommend_item)

#保存推荐结果
def savedata(item,recommend_item):
        db=pymysql.connect(url,username,passwd,dbname)
        print("数据库链接成功")
        cursor=db.cursor()
        for simliaritem in recommend_item:
            sql="insert into similartab values("+"'"+item+"'"+","+"'"+simliaritem[0]+"'"+","+str(simliaritem[1])+")"
            print(sql)
        try:
            cursor.execute(sql)
            db.commit()
            print(sql+"插入成功")
        except:
            db.rollback()
            print(sql+"插入失败")
        db.close()
        print("数据库链接关闭")

#主入口函数
if __name__=="__main__":
   
    sc=CreatSparkContext()
    #加载初始训练数据
    print("===============数据加载阶段================")
    ratingsRDD=prepardata(sc,Path)
    print("========构建相似度矩阵,创建推荐模型==========")
    #物品集合
    itemRDD=ratingsRDD.map(lambda x:(x[1])).distinct()
    #itemlist=itemRDD.collect()
    itemlist=['1','2']
    #物品-用户
    RDD=ratingsRDD.map(lambda x:(x[1],x[0]))
    #物品-用户集合
    item_user=RDD.groupByKey().map(lambda x:(x[0],list(x[1])))
    item_user=item_user.cartesian(item_user).filter(lambda x:x[0][0]!=x[1][0])
    #物品,物品,相似度
    w=item_user.map(lambda x:(x[0][0],x[1][0],calculate(x[0][1],x[1][1])))
    #物品-(物品相似度集合)
    W=w.map(lambda x:(x[0],(x[1],x[2])))
    W=W.groupByKey().map(lambda x:(x[0],list(x[1])))
    print("============物品推荐保存数据================")
    #推荐物品
    recommenditem(itemlist,8)
    sc.stop()