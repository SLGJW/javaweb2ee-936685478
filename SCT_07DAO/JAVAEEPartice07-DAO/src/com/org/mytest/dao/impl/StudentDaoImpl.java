package com.org.mytest.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.mytest.dao.StudentDao;
import com.org.mytest.dbc.DatabaseConnection;
import com.org.mytest.vo.Student;


public class StudentDaoImpl implements StudentDao {
	private Connection conn = null;//�������Ӷ���
	private PreparedStatement pstmt = null;//�����ѯ����
	public StudentDaoImpl() {
		
		this.conn = conn;
	}
	
	@Override
	public void insert(Student stu) throws Exception {
		 String sql = "INSERT INTO stu(Sid,Sname,Sage) VALUES(?,?,?)" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // ������������ݿ�ľ������  
	        try{  
	            // �������ݿ�  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;  
	            pstmt.setInt(1, stu.getSid());  
	            pstmt.setString(2, stu.getSname()); 
	            pstmt.setInt(3, stu.getSage());
	            // �������ݿ���²���  
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	            throw new Exception("���������쳣") ;  
	        }  
	        finally{  
	            // �ر����ݿ�����  
	            dbc.close() ;  
	        }  
		
	}
	public void update(Student stu) throws Exception {
		 String sql = "UPDATE stu SET Sid=?,Sname=? WHERE Sage=?" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // ������������ݿ�ľ������  
	        try{  
	            // �������ݿ�  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setInt(1, stu.getSid());  
	            pstmt.setString(2, stu.getSname());  
	            pstmt.setInt(3,stu.getSage());
	            pstmt.setInt(4, stu.getSsex());
	            // �������ݿ���²���  
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("���������쳣") ;  
	        }  
	        finally{  
	            // �ر����ݿ�����  
	            dbc.close() ;  
	        }  
	}
	public void delete(int userid) throws Exception {
		String sql = "DELETE FROM stu WHERE Sid=?" ;  
        PreparedStatement pstmt = null ;  
        DatabaseConnection dbc = null ;  
        // ������������ݿ�ľ������  
        try{  
            // �������ݿ�  
            dbc = new DatabaseConnection() ;  
            pstmt = dbc.getConnection().prepareStatement(sql) ;           
            pstmt.setInt(1,userid) ;  
            // �������ݿ���²���  
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (Exception e){  
            throw new Exception("���������쳣") ;  
        }  
        finally{  
            // �ر����ݿ�����  
            dbc.close() ;  
        }  
	}
	public Student queryById(int userid) throws Exception {
		   Student stu = null ;  
	        String sql = "SELECT * FROM user WHERE userid=?" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // ������������ݿ�ľ������  
	        try{  
	            // �������ݿ�  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setInt(1, userid);  
	            // �������ݿ��ѯ����  
	            ResultSet rs = pstmt.executeQuery() ;  
	            if(rs.next())  
	            {  
	                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��user����  
	                stu = new Student() ;  
	                stu.setSid(rs.getInt(1));  
	                stu.setSname(rs.getString(2));  
	                stu.setSsex(rs.getInt(3));  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	            throw new Exception("���������쳣") ;  
	        }  
	        finally{  
	            // �ر����ݿ�����  
	            dbc.close() ;  
	        }  
	        return stu ;  
	}
	public List queryAll() throws Exception {
		  List<Student> all = new ArrayList<Student>() ;  
	        String sql = "SELECT * FROM user " ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	  
	        // ������������ݿ�ľ������  
	        try{  
	            // �������ݿ�  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;   
	            // �������ݿ��ѯ����  
	            ResultSet rs = pstmt.executeQuery() ;  
	            while(rs.next()){  
	                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��user����  
	               Student stu = new Student() ;  
	                stu.setSid(rs.getInt(1));  
	                stu.setSname(rs.getString(2));  
	                stu.setSage(rs.getInt(3));   
	  
	                // ����ѯ���������ݼ��뵽List����֮��  
	                all.add(stu) ;  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("���������쳣") ;  
	        }  
	        finally{  
	            // �ر����ݿ�����  
	            dbc.close() ;  
	        }  
	        return all ;  
	    }  
	}

//	public boolean doCreate(Student stu) throws Exception {
//		boolean flag = false;
//		String sql = "INSERT INTO stu(sid.sname.sage.ssex)VALUES(?,?,?,?)";
//		this.pstmt = this.conn.prepareStatement(sql);
//		this.pstmt.setInt(1,stu.getSid());
//		this.pstmt.setString(2, stu.getSname());
//		this.pstmt.setDate(3,new java.sql.Date(stu.getSage().getTime()));
//		this.pstmt.setInt(4, stu.getSsex());
//		if (this.pstmt.executeUpdate()>0) {
//			flag = true;
//		}
//		this.pstmt.close();
//		return flag;
//	}
//
//	public List<Student> findAll(String KeyWord) throws SQLException {
//		List<Student> all = new ArrayList<Student>();
//		String sql = "SELECT * FROM stu WHERE sname like ? OR sage like ?";
//		this.pstmt = this.conn.prepareStatement(sql);
//		this.pstmt.setString(1, "%"+KeyWord+"%");
//		this.pstmt.setString(2, "%"+KeyWord+"%");
//		ResultSet rs = this.pstmt.executeQuery();
//		Student stu = null;
//		while (rs.next()) {
//			stu.setSid(rs.getInt(1));
//			stu.setSname(rs.getString(2));
//			stu.setSage(rs.getDate(3));
//			stu.setSsex(rs.getInt(4));
//			all.add(stu);
//		}
//
//		return all;
//	}
//	@Override
//	public Student findById(int sid) throws SQLException {
//		Student stu = null;
//		String sql = "SELECT * FROM stu WHERE sid=?";
//		this.pstmt = this.conn.prepareStatement(sql);
//		this.pstmt.setInt(1, sid);
//		ResultSet rs = this.pstmt.executeQuery();
//		if (rs.next()) {
//			stu = new Student();
//			stu.setSid(rs.getInt(1));
//			stu.setSname(rs.getString(2));
//			stu.setSage(rs.getDate(3));
//			stu.setSsex(rs.getInt(4));
//		}
//
//		return stu;
//	}

	


