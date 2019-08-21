<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个性推荐</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<base href="<%=basePath%>">
<link rel="icon" type="image/x-icon" href="img/title.ico" />
<link rel="stylesheet" type="text/css" href="./css/style2.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<link rel="stylesheet" type="text/css" href="./css/movieList.css">
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
			<div class="aside"></div>
			<div class="movie-grid">

				<div class="panel-header">
					<span class="panel-more"> <a href="Categoryaction"
						class="textcolor_red" data-act="all-playingMovie-click"> <span>全部</span>
					</a> <span class="panel-arrow panel-arrow-red"></span>
					</span> <span class="panel-title"> <span class="textcolor_red">个性推荐</span>
					</span>
				</div>
				<div class="panel-content">
					<c:if test="${empty sessionScope.usersimilarlist}">
						<h3 align="center">尊敬的用户，你的记录太少，留下你的足迹，才能个性推荐</h3>
					</c:if>
					<c:if test="${!empty sessionScope.usersimilarlist}">
						<div class="movies-list">
							<ul class="movie-list">


								<c:forEach var="u" items="${sessionScope.usersimilarlist }">

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
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="footer"></div>
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/carousel.js">
	</script>
</body>
</html>
