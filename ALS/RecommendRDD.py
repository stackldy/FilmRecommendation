import sys

import pymysql

from pyspark import SparkConf, SparkContext
from pyspark.mllib.recommendation import ALS, Rating

#数据库参数声明
url="rm-m5e8tlshx46qfd4m3jo.mysql.rds.aliyuncs.com"
username="ldy"
passwd="135135LDYldy"
dbname="movie"

#spark应用声明
def CreatSparkContext():
    sparkConf=SparkConf() .setAppName("ALSrecommend").set("spark.ui.showConsoleProgress","false")
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

def SetPath(sc):
    global Path
    global OutPath
    if sc.master[0:5]=="local":
        Path="file:/home/ldy/ALS/input/"
        OutPath="file:/home/ldy/ALS/output/"
    else:
        Path="hdfs://localhost:9000/movie/input/"
        OutPath="hdfs://localhost:9000/movie/output/"
def PrepareData(sc,rawUserData):
    rawRatings=rawUserData.map(lambda line:line.split(",")[:3])
    ratingsRDD=rawRatings.map(lambda x:(x[0],x[1],x[2]))
    users=ratingsRDD.map(lambda x:x[0]).distinct().collect()
    return ratingsRDD,users

#模型保存
def saveModel(sc,model,Path):
    try:
        model.save(sc,Path+"ALSmodel")
        print("以存储 Model 在 ALSmodel")
    except Exception:
        print("Model 已经存在,请删除再存储")

#推荐结果保存到数据库
def saveData(recommendict):
    db=pymysql.connect(url,username,passwd,dbname)
    print("数据库链接成功")
    cursor=db.cursor()
    for key in recommendict:
      sql="insert into rectab values("+key+","+recommendict[key]+")"
      try:
          cursor.execute(sql)
          db.commit()
          print(sql+"插入成功")
      except:
          db.rollback()
          print(sql+"插入失败")
    db.close()
    print("数据库链接关闭")

#主函数
if __name__ == "__main__":
    sc=CreatSparkContext()
    print(Path)
    rawUserData=sc.textFile(Path)
    print("===============数据准备阶段================")
    ratingsRDD,users=PrepareData(sc,rawUserData)
    print("===============训 练 阶 段================")
    print("开始 ALS 训练, 参数 rank=50,iteration=20,lambda=0.01")
    model=ALS.train(ratingsRDD,50,10,0.1)
    print("===============模 型 评 估================")
    testdata = ratingsRDD.map(lambda p: (p[0], p[1]))
    predictions = model.predictAll(testdata).map(lambda r: ((r[0], r[1]), r[2]))
    ratesAndPreds = ratingsRDD.map(lambda r: ((r[0], r[1]), r[2])).join(predictions)
    MSE = ratesAndPreds.map(lambda r: (r[1][0] - r[1][1])**2).mean()
    print("Mean Squared Error = " + str(MSE))
    print("===============保存 Model=================")
    saveModel(sc,model,OutPath)
    print("===============开 始 推 荐=================")
    recommendict={}
    for u in users:
        recommendlist=model.recommendProducts(int(u),8)
        recommendict[u]="'"
        for i in range(0,len(recommendlist)):
           if i<len(recommendlist)-1:
              recommendict[u]=recommendict[u]+str(recommendlist[i].product)+","
           else:
              recommendict[u]=recommendict[u]+str(recommendlist[i].product)+"'"
           #print(recommendlist[i].user,recommendlist[i].product)
    print("===============推 荐 结 束=================")
    print("===============保 存 数 据=================")
    #saveData(recommendict)
    print("===============保 存 成 功=================")
    sc.stop()