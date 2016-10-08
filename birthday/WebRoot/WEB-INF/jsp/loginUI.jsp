<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消费管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>  
  </head>
  <script>
  	function logins(){
		document.forms[0].submit();
	}

	function setClean(){
		document.getElementById("username").value = "";
		document.getElementById("password").value = "";
	}
  </script>
  <body>
  	<div id="login">
  		<h1>用户登录</h1>
  		<s:form name="form1" namespace="/sys" action="login_login">
  			<input type="text" id="username" placeholder="用户名" name="admin.userName"/><em>*</em><br/>
            <label></label><br/><br/>
            <input type="password" id="password" placeholder="密码" name="admin.password"/><em>*</em><br/>
            <label></label><br/><br/>
            <button class="but_login" type="submit">登录</button><br/>
            <span><font style="color: red;"><s:property value="loginResult"/></font></span>
 	 	</s:form>
  	</div>
  	 
  </body>
</html>
