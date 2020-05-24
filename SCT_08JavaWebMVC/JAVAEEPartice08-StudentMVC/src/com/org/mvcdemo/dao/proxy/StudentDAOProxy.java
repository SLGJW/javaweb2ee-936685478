package com.org.mvcdemo.dao.proxy;

import java.util.ArrayList;

import com.org.mvcdemo.dao.StudentDAO;
import com.org.mvcdemo.dao.impl.StudentDAOImpl;
import com.org.mvcdemo.dbc.DatabaseConnection;
import com.org.mvcdemo.vo.Student;

public class StudentDAOProxy implements StudentDAO {
	private DatabaseConnection dbc = null;
	private StudentDAO dao = null;
	
	public StudentDAOProxy() throws Exception {
		// TODO Auto-generated constructor stub
		this.dbc = new DatabaseConnection();
		this.dao = new StudentDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean InsertStudent(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		if(this.dao.InsertStudent(stu)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public boolean DeleteStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		if (this.dao.DeleteStudent(sid)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public boolean UpdateStudent(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		if (this.dao.UpdateStudent(stu)) {
			falg = true;
		}
		this.dbc.close();
		return falg;
	}

	@Override
	public ArrayList<Student> findAllStudents() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> list = this.dao.findAllStudents();
		this.dbc.close();
		return list;
	}

	@Override
	public ArrayList<Student> findByMessage(String info) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> list = this.dao.findByMessage(info);
		this.dbc.close();
		return list;
	}

}
