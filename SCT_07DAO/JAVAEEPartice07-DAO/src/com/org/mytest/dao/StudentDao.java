package com.org.mytest.dao;

import java.util.List;

import com.org.mytest.vo.Student;



public interface StudentDao { 
	// ���Ӳ���  
    public void insert(Student stu) throws Exception ;  
    // �޸Ĳ���  
    public void update(Student stu) throws Exception ;  
    // ɾ������  
    public void delete(int userid) throws Exception ;  
    // ��ID��ѯ����  
    public Student queryById(int userid) throws Exception ;  
    // ��ѯȫ��  
    public List queryAll() throws Exception ;  

}
