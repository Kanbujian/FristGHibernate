<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <br>
     <form action="nikan.jsp" method="get" id="form">
       <div align="center">
       <h3 >USER LOGIN</h3>
       Username <input type="text" name="username"><br><br>
       Password <input type="password" name="password"><br><br>
       <input type="submit" name="submit" value="Login">&nbsp;&nbsp;&nbsp;
       <input type="button" name="submit" value="back">
       </div></form>
       
       
  </body>
</html>
