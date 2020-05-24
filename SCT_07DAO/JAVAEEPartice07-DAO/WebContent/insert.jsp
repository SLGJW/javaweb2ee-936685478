    <%@page import="com.org.mytest.factory.DAOFactory"%>
<%@page import="com.org.mytest.vo.Student"%>
<%@page import="com.org.mytest.dao.StudentDao"%>
<%@ page language="java" contentType="text/html;charset=gb2312"%>  
    <%@ page import="com.org.mytest.*"%>  
    <html>  
    <head>  
        <title>插入用户记录</title>  
    </head>  
    <body>  
        <%  
            //通过DAO工厂获得DAO实现类实例 
            StudentDao stuDAO = DAOFactory.getStudentDAOInstance(); 
            //设置需要插入的用户  
            Student stu = new Student();  
            stu.setSid(10);  
            stu.setSname("小王"); 
            stu.setSage(20);
            stuDAO.insert(stu);
    
        %>  
    </body>  
    </html>  
