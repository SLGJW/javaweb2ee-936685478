package com.org.mytest.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import com.org.mytest.dao.StudentDao;
import com.org.mytest.dao.impl.StudentDaoImpl;
import com.org.mytest.dbc.DatabaseConnection;
import com.org.mytest.vo.Student;

public class StuDAOProxy implements StudentDao {
	private DatabaseConnection dbc = null;
	private StudentDao dao = null;
	public StuDAOProxy() throws ClassNotFoundException, SQLException {
		this.dbc = new DatabaseConnection();
		this.dao = new StudentDaoImpl(this.dbc.getConnection());
	}



	@Override
	public Student findById(int sid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Student stu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student stu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int userid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student queryById(int userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
