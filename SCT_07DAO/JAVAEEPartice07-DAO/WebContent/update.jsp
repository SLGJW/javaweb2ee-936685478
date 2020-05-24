    <%@page import="com.org.mytest.dao.StudentDao"%>
<%@page import="com.org.mytest.factory.DAOFactory"%>
<%@page import="com.org.mytest.vo.Student"%>
<%@ page language="java" contentType="text/html;charset=gb2312"%>  
    <%@ page import="com.org.mytest.*"%>  
    <html>  
    <head>  
        <title>更新用户记录</title>  
    </head>  
    <body>  
        <%  
            //通过DAO工厂获得DAO实现类实例  
            StudentDao stuDAO = DAOFactory.getStudentDAOInstance();  
            //设置需要更新的用户  
            Student stu = new Student();  
            stu.setSid(10);  
            stu.setSname("jim");  
            stu.setSage(21);  
            //执行更新操作  
            stuDAO.update(stu);  
        %>  
    </body>  
    </html>  
