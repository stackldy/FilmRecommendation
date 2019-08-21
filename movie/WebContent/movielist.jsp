<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>电影</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="icon" type="image/x-icon" href="img/title.ico" />
<link rel="stylesheet" type="text/css" href="./css/style2.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<link rel="stylesheet" type="text/css" href="./css/movieList.css">
<link rel="stylesheet" type="text/css" href="./css/page.css">

<style>
* {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
}

a:active, a:hover {
	outline-width: 0;
}

img {
	border-style: none;
}

body {
	font-family: Microsoft YaHei, Helvetica, Arial, sans-serif;
	background-color: #fff;
	-webkit-font-smoothing: subpixel-antialiased;
}

input {
	outline: none;
}

input[type=search]::-webkit-search-cancel-button {
	-webkit-appearance: none;
	//
	此处去掉默认的小×
}
</style>
</head>

<body>
	<div class="header">
		<div class="header-top">
			<div class="header-inner">
				<h1>
					<a href="javascript:void(0)" class="logo"></a>
				</h1>
				<div class="nav">
					<ul>
						<li><a href="Movieaction">首页</a></li>
						<li><a href="Categoryaction">榜单</a></li>
						<c:if test="${empty user}">
							<li><a href="login.jsp">登录</a></li>
						</c:if>
						<c:if test="${!empty user}">
							<li><a href="Recommendaction">个性推荐</a></li>
							<li><a href="Loginoutaction">注销</a></li>
						</c:if>
					</ul>
				</div>
				<div class="app-download"></div>
				<form action="">
					<input name="searchMovie" class="search" type="search"
						maxlength="32" placeholder="找影视剧、影人、影院" autocomplete="off">
					<input class="submit" type="submit" value="">
				</form>

			</div>
		</div>
	</div>

	<div class="main">
		<div class="main-inner">
			<div class="movies-channel">
				<div class="tags-panel">
					<ul class="tags-lines">
						<li class="tags-line" data-val="{tagTypeName:'cat'}">
							<div class="tags-title">类型 :</div>

							<ul class="tags">
								<li class="active" data-state-val="{catTagName:'0'}"><a
									data-act="tag-click" data-val="{'0'}"
									href="Querymovieaction?type=0&page=0" style="cursor: default">全部</a>
								</li>

								<li><a data-act="tag-click" data-val="{1}"
									href="Querymovieaction?type=1&page=0">动作</a></li>

								<li><a data-act="tag-click" data-val="{2}"
									href="Querymovieaction?type=2&page=0">冒险</a></li>

								<li><a data-act="tag-click" data-val="{3}"
									href="Querymovieaction?type=3&page=0">动漫</a></li>

								<li><a data-act="tag-click" data-val="{'4'}"
									href="Querymovieaction?type=4&page=0">儿童</a></li>

								<li><a data-act="tag-click" data-val="{'5'}"
									href="Querymovieaction?type=5&page=0">喜剧</a></li>

								<li><a data-act="tag-click" data-val="{'6'}"
									href="Querymovieaction?type=6&page=0">犯罪</a></li>

								<li><a data-act="tag-click" data-val="{'7'}"
									href="Querymovieaction?type=7&page=0">记录</a></li>

								<li><a data-act="tag-click" data-val="{'8'}"
									href="Querymovieaction?type=8&page=0">戏剧</a></li>

								<li><a data-act="tag-click" data-val="{'9'}"
									href="Querymovieaction?type=9&page=0">幻想</a></li>

								<li><a data-act="tag-click" data-val="{'10'}"
									href="Querymovieaction?type=10&page=0">黑色</a></li>

								<li><a data-act="tag-click" data-val="{'11'}"
									href="Querymovieaction?type=11&page=0">恐怖</a></li>

								<li><a data-act="tag-click" data-val="{'12'}"
									href="Querymovieaction?type=12&page=0">音乐</a></li>

								<li><a data-act="tag-click" data-val="{'13'}"
									href="Querymovieaction?type=13&page=0">神秘</a></li>

								<li><a data-act="tag-click" data-val="{'14'}"
									href="Querymovieaction?type=14&page=0">浪漫</a></li>

								<li><a data-act="tag-click" data-val="{'15'}"
									href="Querymovieaction?type=15&page=0">科幻</a></li>

								<li><a data-act="tag-click" data-val="{'16'}"
									href="Querymovieaction?type=16&page=0">惊悚</a></li>

								<li><a data-act="tag-click" data-val="{'17'}"
									href="Querymovieaction?type=17&page=0">战争</a></li>

								<li><a data-act="tag-click" data-val="{'18'}"
									href="Querymovieaction?type=18&page=0">西方</a></li>

								<li><a data-act="tag-click" data-val="{'19'}"
									href="Querymovieaction?type=19&page=0">家庭</a></li>

								<li><a data-act="tag-click" data-val="{其他}"
									href="Javascript:void(0)">其他</a></li>
							</ul>
						</li>
						<li class="tags-line tags-line-border"
							data-val="{tagTypeName:'source'}">
							<div class="tags-title">区域 :</div>
							<ul class="tags">
								<li class="active" data-state-val="{sourceTagName:'全部'}"><a
									data-act="tag-click" data-val="{TagName:'全部'}"
									href="javascript:void(0);" style="cursor: default">全部</a></li>
							</ul>
						</li>
						<li class="tags-line tags-line-border"
							data-val="{tagTypeName:'year'}">
							<div class="tags-title">年代 :</div>
							<ul class="tags">
								<li class="active" data-state-val="{ yearTagName:'全部'}"><a
									data-act="tag-click" data-val="{TagName:'全部'}"
									href="javascript:void(0);" style="cursor: default">全部</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>

			<div class="movies-panel">
				<div class="movies-sorter">
					<div class="cat-sorter">
						<ul>
							<li><span class="sort-control-group" data-act="sort-click"
								data-val="{tagId: 1 }"
								onclick="location.href='Querymovieaction?type=${sessionScope.sortType}&page=${sessionScope.page}'">
									<c:if test="${sessionScope.sortOrder==null }">
										<span class="sort-control sort-radio sort-radio-checked"></span>
									</c:if> <c:if test="${sessionScope.sortOrder !=null }">
										<span class="sort-control sort-radio"></span>
									</c:if> <span class="sort-control-label">按热门排序</span>
							</span></li>
							<li><span class="sort-control-group" data-act="sort-click"
								data-val="{tagId: 2 }" data-href="?sortId=2"
								onclick="location.href='Querymovieaction?type=${sessionScope.sortType}&order=showyear&page=${sessionScope.page}' ">

									<c:if test="${sessionScope.sortOrder =='showyear' }">
										<span class="sort-control sort-radio sort-radio-checked"></span>
									</c:if> <c:if test="${sessionScope.sortOrder !='showyear' }">
										<span class="sort-control sort-radio"></span>
									</c:if> <span class="sort-control-label">按时间排序</span>
							</span></li>
							<li><span class="sort-control-group" data-act="sort-click"
								data-val="{tagId: 3 }" data-href="?sortId=3"
								onclick="location.href='Querymovieaction?type=${sessionScope.sortType}&order=averating&page=${sessionScope.page}'">

									<c:if test="${sessionScope.sortOrder =='averating' }">
										<span class="sort-control sort-radio sort-radio-checked"></span>
									</c:if> <c:if test="${sessionScope.sortOrder !='averating' }">
										<span class="sort-control sort-radio"></span>
									</c:if> <span class="sort-control-label">按评价排序</span>
							</span></li>
						</ul>
					</div>
				</div>

				<div class="movies-list">
					<ul class="movie-list">


						<c:forEach var="u" items="${sessionScope.movielist }">

							<li>
								<div class="movie-item">
									<a href="Moviedetailaction?movieid=${u.movieid}"
										target="_blank" data-act="movie-click"
										data-val="{movieid:1208282}">
										<div class="movie-poster">
											<img src="${u.picture}">
										</div>
									</a>
									<div class="channel-action channel-action-sale">
										<a>详情</a>
									</div>

									<div class="movie-ver"></div>
								</div>
								<div class="channel-detail movie-item-title"
									title="${u.moviename }">
									<a href="Moviedetailaction?movieid=${u.movieid}"
										target="_blank" data-act="movies-click"
										data-val="{movieId:1208282}">${u.moviename }</a>
								</div>

								<div class="channel-detail channel-detail-orange">
									<i class="integer">${u.averating}</i>
								</div>

							</li>
						</c:forEach>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="page" align="center">
		<ul class="list-pager">
			<li><a class="page_2"
				href="Querymovieaction?type=${sessionScope.sortType}&page=${sessionScope.prepage}">上一页</a>
			</li>
			<c:if test="${sessionScope.page !=100}">
				<li class="active"><a class="page_1" href="javascript:void(0);"
					style="cursor: default">${sessionScope.page}</a></li>
			</c:if>
			<c:forEach var="u" items="${sessionScope.pagelist }">
				<li><a class="page_2"
					href="Querymovieaction?type=${sessionScope.sortType}&page=${u}">${u}</a></li>
			</c:forEach>
			<li class="sep">...</li>
			<c:if test="${sessionScope.page ==100}">
				<li class="active"><a class="page_1" href="javascript:void(0);"
					style="cursor: default">100</a></li>
			</c:if>
			<c:if test="${sessionScope.page !=100}">
				<li><a class="page_27731"
					href="Querymovieaction?type=${sessionScope.sortType}&page=100">100</a>
				</li>
			</c:if>
			<li><a class="page_2"
				href="Querymovieaction?type=${sessionScope.sortType}&page=${sessionScope.lastpage}">下一页</a>
			</li>
		</ul>
	</div>
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/page.js"></script>
	<script type="text/javascript">
		  var active=new Array(23);
		
		 $("[data-act='tag-click']").each(function(key,value){
			if($(this).html()=="${sessionScope.category}"){
				$(this).parent().addClass('active').siblings().removeClass('active');
			}
            active[key] = $(this).html();      //如果是其他标签 用 html();
        });	
	</script>
</body>
</html>
