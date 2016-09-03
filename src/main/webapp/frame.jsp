<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="80,*">
   <frame name="top" src="<%=basePath %>frame/top.jsp">
   <frameset cols="150,*" id="main">

     <frame src="<%=basePath %>frame/left.jsp"> 
     <frame name="right" src="<%=basePath %>frame/right.jsp">
   </frameset>
</frameset>
</html>