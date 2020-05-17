<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="student" scope = "request" class="com.org.javabean.vo.Student"></jsp:useBean>
	用户名：<h3><jsp:getProperty property="username" name="student"/></h3>
	密码：<h3><jsp:getProperty property="password" name="student"/></h3>
	性别：<h3><jsp:getProperty property="sex" name="student"/></h3>
	<%!String info = ""; %>
	<% 
		String [] hobby = student.getHobby();
		for(String info1 : hobby){
			info += info1 + '、';
		}
	%>
	爱好：<h3><%=info %></h3>
	日期：<h3><jsp:getProperty property="date" name="student"/></h3>
</body>
</html>