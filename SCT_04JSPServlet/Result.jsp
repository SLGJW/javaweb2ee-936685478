<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户名：<%=request.getParameter("username") %><br>
	密码：<%=request.getParameter("password") %><br>
	性别：<%=request.getParameter("sex") %><br>
	<%
	String [] list = request.getParameterValues("hobby");
	String hobby = "";
	for (String s : list) {
		hobby += s + "、";
	} 
	%>
	爱好：<%=hobby %><br>
	日期：<%=request.getParameter("date") %>
</body>
</html>