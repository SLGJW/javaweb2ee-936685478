package com.org.mvcdemo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.org.mvcdemo.dao.StudentDAO;
import com.org.mvcdemo.vo.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public StudentDAOImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public boolean InsertStudent(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		String sql = "insert into student values(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, stu.getSid());
		this.pstmt.setString(2, stu.getSname());
		this.pstmt.setString(3, stu.getSbirthday());
		this.pstmt.setInt(4, stu.getSsex());
		if (this.pstmt.executeUpdate() > 0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public boolean DeleteStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		String sql = "delete from student where sid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, sid);
		if (this.pstmt.executeUpdate() > 0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public boolean UpdateStudent(Student stu) throws Exception {
		// TODO Auto-generated method stub
		boolean falg = false;
		String sql = "update student set sname = ? , sbirthday = ?,ssex = ? where sid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, stu.getSname());
		this.pstmt.setString(2, stu.getSbirthday());
		this.pstmt.setInt(3, stu.getSsex());
		this.pstmt.setString(4, stu.getSid());
		if (this.pstmt.executeUpdate() > 0) {
			falg = true;
		}
		this.conn.close();
		return falg;
	}

	@Override
	public ArrayList<Student> findAllStudents() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Student student = new Student();
			student.setSid(rs.getString(1));
			student.setSname(rs.getString(2));
			student.setSbirthday(rs.getString(3));
			list.add(student);
		}
		this.conn.close();
		return list;
	}

	@Override
	public ArrayList<Student> findByMessage(String info) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student where sid like ? or sname like ? or sbirthday  like binary  ? ";		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + info + "%");
		this.pstmt.setString(2, "%" + info + "%");
		this.pstmt.setString(3, "%" + info + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Student student = new Student();
			student.setSid(rs.getString(1));
			student.setSname(rs.getString(2));
			student.setSbirthday(rs.getString(3));
			list.add(student);
		}
		return list;
	}

}
