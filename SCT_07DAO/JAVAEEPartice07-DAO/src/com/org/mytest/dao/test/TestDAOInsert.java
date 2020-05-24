package com.org.mytest.dao.test;

import com.org.mytest.factory.DAOFactory;
import com.org.mytest.vo.Student;

public class TestDAOInsert {
	public static void main(String[] args) throws Exception {
		Student stu = null;
		for (int i = 0; i < 4; i++) {
			stu = new Student();
			stu.setSid(1001+i);
			stu.setSname("Ð¡Íõ"+i);
			stu.setSage(new java.util.Date());
			stu.setSsex(1+i);
			DAOFactory.getStudentDaoInstance().doCreate(stu);
		}
	}

}
