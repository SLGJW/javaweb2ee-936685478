package com.org.mytest.factory;

import com.org.mytest.dao.StudentDao;
import com.org.mytest.dao.impl.StudentDaoImpl;

public class DAOFactory{  
    public static StudentDao getStudentDAOInstance(){
		return new StudentDaoImpl();  
    	
    }  
}  
