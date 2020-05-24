package com.org.mytest.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//加载驱动类
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	//创建URL连接符
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
	 //定义数据库连接用户名  
	private static final String DBUSER = "MyStudent";
	//定义数据库连接密码  
	private static final String DBPASSWORD = "123456";
	//定义数据库连接对象  
	private Connection conn = null;
	 //构造方法，加载驱动  
	public DatabaseConnection()  {
		
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			System.out.println("加载驱动失败");
		}
		
	}
	// 取得数据库连接  
	public Connection getConnection() {
		return this.conn;
		
	}
	// 关闭数据库连接  
	public void close() {
		if (this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("数据库连接关闭失败");
			}
			
		}
	}
	

}
