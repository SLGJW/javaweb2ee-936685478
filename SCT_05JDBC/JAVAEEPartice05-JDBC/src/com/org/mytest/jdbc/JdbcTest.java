package com.org.mytest.jdbc;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.org.mytest.ov.Student;
import com.sun.corba.se.pept.transport.Connection;

public class JdbcTest {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "25257758";
	
	private java.sql.Connection conn = null;
	public JdbcTest() throws Exception {
		Class.forName(DBDRIVER);
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);		
	}
	public boolean addMessage(Student student) throws Exception {
		boolean falg = false;
		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement pds = this.conn.prepareStatement(sql);
		pds.setString(1, student.getSid());
		pds.setString(2, student.getSname());
		pds.setString(3, student.getSbirthday());
		pds.setInt(4, student.getSsex());
		if(pds.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}
	public boolean UpdateMessage(Student s) throws Exception{
		boolean falg=false;
		String sql = "update student set sname = ?,sbirthday = ?,ssex = ? where sid = ?";
		PreparedStatement pds =  this.conn.prepareStatement(sql);
		pds.setString(1, s.getSname());
		pds.setString(2, s.getSbirthday());
		pds.setInt(3, s.getSsex());
		pds.setString(4, s.getSid());
		if(pds.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
		
	}
	public boolean DeleteMessage(String sid) throws SQLException {
		boolean falg=false;
		String sql = "delete from student where sid = ?";
		PreparedStatement pds = this.conn.prepareStatement(sql);
		pds.setString(1, sid);
		if(pds.executeUpdate()>0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}
	public ArrayList<Student> findAll() throws Exception{
		ArrayList<Student> sList = new ArrayList<Student>();
		String sql = "select * from student";
		PreparedStatement pds = this.conn.prepareStatement(sql);
		ResultSet rs = pds.executeQuery();
		while (rs.next()) {
			Student s = new Student();
			s.setSid(rs.getString(1));
			s.setSname(rs.getString(2));
			s.setSbirthday(rs.getString(3));
			s.setSsex(rs.getInt(4));
			sList.add(s);
		}
		this.conn.close();
		return sList;
	} 
	public ArrayList<Student> termFind(String info1,String info2,String info3,String info4) throws Exception{
		ArrayList<Student> list = new ArrayList<Student>();
		int info41 = Integer.parseInt(info4);
		String sql = "select * from student where sid = ? or sname = ? or sbirthday = ? or ssex = ?";
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, info1);
		ps.setString(2, info2);
		ps.setString(3, info3);
		ps.setInt(4, info41);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Student student = new Student();
			student.setSid(rs.getString(1));
			student.setSname(rs.getString(2));
			student.setSbirthday(rs.getString(3));
			student.setSsex(rs.getInt(4));
			list.add(student);		
		}
		this.conn.close();
		return list;
	}

}
