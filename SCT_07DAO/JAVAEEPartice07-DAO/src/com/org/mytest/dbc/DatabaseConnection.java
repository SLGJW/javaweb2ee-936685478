package com.org.mytest.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//����������
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	//����URL���ӷ�
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
	 //�������ݿ������û���  
	private static final String DBUSER = "MyStudent";
	//�������ݿ���������  
	private static final String DBPASSWORD = "123456";
	//�������ݿ����Ӷ���  
	private Connection conn = null;
	 //���췽������������  
	public DatabaseConnection()  {
		
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			System.out.println("��������ʧ��");
		}
		
	}
	// ȡ�����ݿ�����  
	public Connection getConnection() {
		return this.conn;
		
	}
	// �ر����ݿ�����  
	public void close() {
		if (this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("���ݿ����ӹر�ʧ��");
			}
			
		}
	}
	

}
