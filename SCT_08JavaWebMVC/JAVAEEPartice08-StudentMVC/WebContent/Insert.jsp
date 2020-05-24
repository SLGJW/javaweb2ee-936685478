<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
<h1><p>学生信息录入</p></h1>
<form action="Insert" method="post">
	ID：<input type="text" name="sid"><br>
	姓名：<input type="text" name="sname"><br>
	出生日期：<input type="date" name="sbirthday"  id = 'date' placeholder="yyyy-mm-dd"><br>
	性别：<input type="radio" name="ssex" value="1" checked="checked">男
		  <input type="radio" name="ssex" value="0">女<br>
		  <input type="submit" value = "提交" ><input type="reset" value = "重置">
</form>
</body>
</html>