<%@ page language="java" import="java.util.* ,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    This is my JSP page.
	
    <%String username="Tylor Swift";
      String sex="gril";
      String BrithYear="1989";
      Date data=new Date();
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String timer=sdf.format(data);
     %>
     歌手名：<%=username %>
     出生年份：<%=BrithYear %>
     当前时间：<%=timer %> 
     <div align="center">
     客户端的主机名：<%=request.getLocalName() %><br>
       获取服务器的IP地址：<%=request.getLocalAddr()%><br>
        获取服务器的端口号：<%=request.getLocalPort()%><br>
         获取客户提交信息的方法：<%=request.getMethod() %><br>
          获取使用的协议：<%=request.getProtocol() %><br>
           获取查询的字符串：<%=request.getQueryString() %> <br>
           获取文件头信息为host的值：<%=request.getHeader("Host") %><br>
      获取文件头信息为User-Agent的值：<%=request.getHeader("user-agent") %><br>
      basePath地址：<%=basePath %>
       <%-- <% 
       try{
       request.setAttribute("money", 98/0);}
       catch(Exception e){
       request.setAttribute("money", "信息出错啦"); 
       } %>
       <jsp:forward page="nikan.jsp"></jsp:forward> --%>
       
       </div>    
  
 
  </body>
</html>
