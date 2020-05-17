<%@page import="java.util.ArrayList,com.org.mytest.ov.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询界面</title>
</head>
<body>
	<form action="Select" method = "post" >
		<input type = "text" name = "info" value = "<% if(request.getAttribute("info1") != null){%><%=request.getAttribute("info1") %><%} %>"  placeholder = "学号/姓名/出生日期/性别">&nbsp;&nbsp;&nbsp;
		<input type="submit" value = "查询">
		<table>
	<tr class="tr">
		<th>学号</th>
		<th>姓名</th>
		<th>出生日期</th>
	</tr>
	<%
	if(request.getAttribute("list") != null){
		ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
 		for (Student stu1 : list) {
 %>
 	<tr class="tr">
 		<td><%=stu1.getSid() %></td>
 		<td><%=stu1.getSname() %></td>
 		<td><%=stu1.getSbirthday() %></td>
 	</tr>
 <%} 
	}
 %>
</table>
</form>
	
</body>
</html>