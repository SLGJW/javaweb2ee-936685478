    <%@page import="com.org.mytest.factory.DAOFactory"%>
<%@page import="com.org.mytest.vo.Student"%>
<%@page import="com.org.mytest.dao.StudentDao"%>
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
            //������Ҫ������û�  
            Student stu = new Student();  
            stu.setSid(10);  
            stu.setSname("С��"); 
            stu.setSage(20);
            stuDAO.insert(stu);
    
        %>  
    </body>  
    </html>  
