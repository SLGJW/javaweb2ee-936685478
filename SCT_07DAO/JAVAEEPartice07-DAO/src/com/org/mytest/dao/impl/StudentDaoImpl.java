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
	private Connection conn = null;//定义链接对象
	private PreparedStatement pstmt = null;//定义查询对象
	public StudentDaoImpl() {
		
		this.conn = conn;
	}
	
	@Override
	public void insert(Student stu) throws Exception {
		 String sql = "INSERT INTO stu(Sid,Sname,Sage) VALUES(?,?,?)" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // 下面是针对数据库的具体操作  
	        try{  
	            // 连接数据库  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;  
	            pstmt.setInt(1, stu.getSid());  
	            pstmt.setString(2, stu.getSname()); 
	            pstmt.setInt(3, stu.getSage());
	            // 进行数据库更新操作  
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	            throw new Exception("操作出现异常") ;  
	        }  
	        finally{  
	            // 关闭数据库连接  
	            dbc.close() ;  
	        }  
		
	}
	public void update(Student stu) throws Exception {
		 String sql = "UPDATE stu SET Sid=?,Sname=? WHERE Sage=?" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // 下面是针对数据库的具体操作  
	        try{  
	            // 连接数据库  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setInt(1, stu.getSid());  
	            pstmt.setString(2, stu.getSname());  
	            pstmt.setInt(3,stu.getSage());
	            pstmt.setInt(4, stu.getSsex());
	            // 进行数据库更新操作  
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("操作出现异常") ;  
	        }  
	        finally{  
	            // 关闭数据库连接  
	            dbc.close() ;  
	        }  
	}
	public void delete(int userid) throws Exception {
		String sql = "DELETE FROM stu WHERE Sid=?" ;  
        PreparedStatement pstmt = null ;  
        DatabaseConnection dbc = null ;  
        // 下面是针对数据库的具体操作  
        try{  
            // 连接数据库  
            dbc = new DatabaseConnection() ;  
            pstmt = dbc.getConnection().prepareStatement(sql) ;           
            pstmt.setInt(1,userid) ;  
            // 进行数据库更新操作  
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (Exception e){  
            throw new Exception("操作出现异常") ;  
        }  
        finally{  
            // 关闭数据库连接  
            dbc.close() ;  
        }  
	}
	public Student queryById(int userid) throws Exception {
		   Student stu = null ;  
	        String sql = "SELECT * FROM user WHERE userid=?" ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	        // 下面是针对数据库的具体操作  
	        try{  
	            // 连接数据库  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setInt(1, userid);  
	            // 进行数据库查询操作  
	            ResultSet rs = pstmt.executeQuery() ;  
	            if(rs.next())  
	            {  
	                // 查询出内容，之后将查询出的内容赋值给user对象  
	                stu = new Student() ;  
	                stu.setSid(rs.getInt(1));  
	                stu.setSname(rs.getString(2));  
	                stu.setSsex(rs.getInt(3));  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	            throw new Exception("操作出现异常") ;  
	        }  
	        finally{  
	            // 关闭数据库连接  
	            dbc.close() ;  
	        }  
	        return stu ;  
	}
	public List queryAll() throws Exception {
		  List<Student> all = new ArrayList<Student>() ;  
	        String sql = "SELECT * FROM user " ;  
	        PreparedStatement pstmt = null ;  
	        DatabaseConnection dbc = null ;  
	  
	        // 下面是针对数据库的具体操作  
	        try{  
	            // 连接数据库  
	            dbc = new DatabaseConnection() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;   
	            // 进行数据库查询操作  
	            ResultSet rs = pstmt.executeQuery() ;  
	            while(rs.next()){  
	                // 查询出内容，之后将查询出的内容赋值给user对象  
	               Student stu = new Student() ;  
	                stu.setSid(rs.getInt(1));  
	                stu.setSname(rs.getString(2));  
	                stu.setSage(rs.getInt(3));   
	  
	                // 将查询出来的数据加入到List对象之中  
	                all.add(stu) ;  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("操作出现异常") ;  
	        }  
	        finally{  
	            // 关闭数据库连接  
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

	


