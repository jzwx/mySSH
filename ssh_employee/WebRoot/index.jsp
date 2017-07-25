<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/reset.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
<script type="text/javascript">
function ChangeCodeImg(obj)
{
	var img1=document.getElementById("checkImg");
	img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime(); //加时间戳防止缓存
    //obj.src="checkImg?d="+timenow;
}
</script>
</head>

<body>
<div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl">
				<a href="#"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="慕课网"></a>
			</div>
			<h3 class="welcome_title">欢迎登陆</h3>
		</div>
	</div>
</div>
<s:form action="employee_login" method="post" namespace="/">
<div class="loginBox">
	<div class="login_cont">
		<ul class="login">
			<li class="l_tit">用户名</li>
			<li class="mb_10"><input type="text" name="username" class="login_input user_icon"><h3><s:actionerror/></h3></li>
			<li class="l_tit">密码</li>
			<li class="mb_10"><input type="password" name="password" class="login_input user_icon"></li>
			<li class="l_tit">验证码</li>
			<li class="mb_10"><input type="text" name="checkcode" class="login_input user_icon" maxlength="4" autocomplete="off" onblur="validateCode()">
			<img id="checkImg" src="${pageContext.request.contextPath}/checkImg.action" onclick="ChangeCodeImg()" title="点击更换验证码"><a href="#" onclick="ChangeCodeImg()">看不清楚，点击换一张</a>
			<span id="codeError"></span>
    		<span style="color:red;"><s:actionerror /></span>
			</li>
			<li><input type="submit" value="" class="login_btn"></li>
		</ul>
		<div class="login_partners">
			<p class="l_tit">使用合作方账号登陆网站</p>
			<ul class="login_list clearfix">
				<li><a href="#">QQ</a></li>
				<li><span>|</span></li>
				<li><a href="#">网易</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
			</ul>
		</div>
	</div>
	
</div>
</s:form>

<div class="hr_25"></div>
<div class="footer">
	<p><a href="#">慕课简介</a><i>|</i><a href="#">慕课公告</a><i>|</i> <a href="#">招纳贤士</a><i>|</i><a href="#">联系我们</a><i>|</i>客服热线：400-675-1234</p>
	<p>Copyright &copy; 2006 - 2014 慕课版权所有&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;京ICP证B1034-8373号&nbsp;&nbsp;&nbsp;某市公安局XX分局备案编号：123456789123</p>
	<p class="web"><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="${pageContext.request.contextPath}/images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>