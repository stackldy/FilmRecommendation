<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>">

<title>登录</title>

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
<title>登录界面</title>
<link rel="icon" type="image/x-icon" href="img/title.ico" />
<link href="css/default.css" rel="stylesheet" type="text/css" />
<!--必要样式-->
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<link href="css/loaders.css" rel="stylesheet" type="text/css" />
<style>
#reg {
	border-radius: 50px;
	background: transparent;
	padding: 10px 50px;
	border: 2px solid #4FA1D9;
	color: #4FA1D9;
	text-transform: uppercase;
	font-size: 11px;
	-webkit-transition-property: background, color;
	transition-property: background, color;
	-webkit-transition-duration: .2s;
	transition-duration: .2s;
}
</style>
</head>
<body>
	<div class='login'>
		<div class='login_title'>
			<span>用户登录</span>
		</div>
		<div class='login_fields'>
			<div class='login_fields__user'>
				<div class='icon'>
					<img alt="" src='img/user_icon_copy.png'>
				</div>
				<form action="Loginaction" method="post" id="form">

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
				<input name="code" placeholder='验证码' maxlength="4" type='text'
					name="ValidateNum" autocomplete="off">
				<div class='validation' style="opacity: 1; right: -5px; top: -3px;">
					<canvas class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
				</div>
			</div>
			<div class='login_fields__submit'>
				<input type='button' value='登录'> <a href="regist.jsp"
					id="reg">注册</a>

			</div>
			</form>
		</div>
		<div class='success'></div>
		<div class='disclaimer'>
			<p>欢迎登陆用户登录系统</p>
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
	<script src="js/login.js" type="text/javascript"></script>
</body>
</html>
