    <%@page import="com.org.mytest.dao.StudentDao"%>
<%@page import="com.org.mytest.factory.DAOFactory"%>
<%@page import="com.org.mytest.vo.Student"%>
<%@ page language="java" contentType="text/html;charset=gb2312"%>  
    <%@ page import="com.org.mytest.*"%>  
    <html>  
    <head>  
        <title>�����û���¼</title>  
    </head>  
    <body>  
        <%  
            //ͨ��DAO�������DAOʵ����ʵ��  
            StudentDao stuDAO = DAOFactory.getStudentDAOInstance();  
            //������Ҫ���µ��û�  
            Student stu = new Student();  
            stu.setSid(10);  
            stu.setSname("jim");  
            stu.setSage(21);  
            //ִ�и��²���  
            stuDAO.update(stu);  
        %>  
    </body>  
    </html>  
