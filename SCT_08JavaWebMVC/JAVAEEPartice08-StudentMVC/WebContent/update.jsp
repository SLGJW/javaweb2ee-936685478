<%@page import="com.org.mvcdemo.vo.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%!
	String sid,sname,sbirthday;
	int ssex = 3;
%>
<%
		request.setCharacterEncoding("utf-8");
		ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
		System.out.println(list);
 		for (Student stu1 : list) {
 			sid = stu1.getSid();
 			sname = stu1.getSname();
 			sbirthday = stu1.getSbirthday();
 			ssex = stu1.getSsex();
 		}
%>
<title>的修改页面</title>
</head>
<body>
	<h1><p><%=sname %>学生的信息修改</p></h1>
	<form action="Update" method="post">
			<input type="hidden" name="sid" value = <%=sid %>>
		ID：<input type="text" name="sid" value = <%=sid %> disabled="disabled"><br>
		姓名：<input type="text" name="sname" value = <%=sname %>><br>
		出生日期：<input type="date" name="sbirthday"  id = 'date' placeholder="yyyy-mm-dd" value = <%=sbirthday %>><br>
		性别：<input type="radio" name="ssex" value="1" <% if(ssex == 1){%>checked="checked"<%} %>>男
			  <input type="radio" name="ssex" value="0" <% if(ssex == 0){%>checked="checked"<%} %>>女<br>
		<input type="submit" value = "提交" ><input type="reset" value = "重置">
	</form>
</body>
</html>