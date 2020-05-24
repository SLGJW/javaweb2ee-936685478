package com.org.mytest.dao.test;

import java.util.Iterator;
import java.util.List;

import com.org.mytest.factory.DAOFactory;
import com.org.mytest.vo.Student;

public class TestDAOSelect {
	public static void main(String[] args) {
		List<Student> all  = DAOFactory.getStudentDaoInstance().findAll(KeyWord);
		Iterator<Student> iter = all.iterator();
		while (iter.hasNext()) {
			Student student = iter.next();
			System.out.println(student.getSid()+"¡¢"+student.getSname());
		}
	}

}
