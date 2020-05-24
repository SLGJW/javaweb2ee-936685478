package com.org.mvcdemo.factory;

import com.org.mvcdemo.dao.StudentDAO;
import com.org.mvcdemo.dao.proxy.StudentDAOProxy;

public class StudentFactory {
	public static StudentDAO getStudentInstance() throws Exception {
		return new StudentDAOProxy();
	}
}
