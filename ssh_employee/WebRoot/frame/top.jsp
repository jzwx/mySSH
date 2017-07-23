<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
</style>
   
<body bgcolor="#0099FF">
<div class="div1">
欢迎您：<s:property value="#session.existEmployee.ename"/>&nbsp;&nbsp;<a href="javascript:window.parent.location='employee_logout.action'">退出登录</a>
</div>
</body>
</html>
