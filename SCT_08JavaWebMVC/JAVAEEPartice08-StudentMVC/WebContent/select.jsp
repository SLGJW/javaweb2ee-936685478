<%@page import="java.util.ArrayList"%>
<%@page import="com.org.mvcdemo.factory.StudentFactory"%>
<%@page import="com.org.mvcdemo.vo.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询界面</title>
</head>
<body>
	<a href="showMessage.jsp"><button>返回</button></a>
	<form action="Select" method = "post" >
		<input type = "text" name = "info" value = "<%if(request.getAttribute("info") != null){%><%=request.getAttribute("info") %><%} %>"  placeholder = "学号/姓名/出生日期">&nbsp;&nbsp;&nbsp;
		<input type="submit" value = "查询">
		<table>
	<tr class="tr">
		<th>学号</th>
		<th>姓名</th>
		<th>出生日期</th>
	</tr>
	<%
	if(request.getAttribute("info") != null){
		ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
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