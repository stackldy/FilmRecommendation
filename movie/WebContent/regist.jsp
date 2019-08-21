<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!-- page import 指令导入jar包 jsp:includent 用来导入资源 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE >
<html>
<head>
<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>注册界面</title>
<link rel="icon" type="image/x-icon" href="img/title.ico" />
<link href="css/default.css" rel="stylesheet" type="text/css" />
<!--必要样式-->
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/loaders.css" rel="stylesheet" type="text/css" />
<style>
html, body {
	background: url("img/Starry5.jpg") no-repeat;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<div class='login'>
		<div class='login_title'>
			<span>用户注册</span>
		</div>
		<div class='login_fields'>
			<div class='login_fields__user'>
				<div class='icon'>
					<img alt="" src='img/user_icon_copy.png'>
				</div>
				<form action="Registeraction" method="post" id="form">

					<input name="login" placeholder='用户名' maxlength="16" type='text'
						autocomplete="off" value="" />
					<div class='validation'>
						<img alt="" src='img/tick.png'>
					</div>
			</div>
			<div class='login_fields__password'>
				<div class='icon'>
					<img alt="" src='img/lock_icon_copy.png'>
				</div>
				<input name="pwd" placeholder='密码' maxlength="16" type='text'
					autocomplete="off" value="">
				<div class='validation'>
					<img alt="" src='img/tick.png'>
				</div>
			</div>
			<div class='login_fields__password'>
				<div class='icon'>
					<img alt="" src='img/key.png'>
				</div>
				<input name="code" placeholder='邮箱' type='text' name="ValidateNum"
					autocomplete="off">

			</div>
			<div class='login_fields__submit'>
				<input type='button' value='注册'>
			</div>
			</form>
		</div>
		<div class='success'></div>
		<div class='disclaimer'>
			<p>欢迎登陆用户注册系统</p>
		</div>
	</div>
	<div class='authent'>
		<div class="loader"
			style="height: 44px; width: 44px; margin-left: 28px;">
			<div class="loader-inner ball-clip-rotate-multiple">
				<div></div>
				<div></div>
				<div></div>
			</div>
		</div>
		<p>认证中...</p>
	</div>
	<div class="OverWindows"></div>
	<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src='js/stopExecutionOnTimeout.js?t=1'></script>
	<script src="layui/layui.js" type="text/javascript"></script>
	<script src="js/Particleground.js" type="text/javascript"></script>
	<script src="js/Treatment.js" type="text/javascript"></script>
	<script src="js/jquery.mockjax.js" type="text/javascript"></script>
	<script src="js/register.js" type="text/javascript"> </script>
</body>
</html>

