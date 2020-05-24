package com.org.mytest.dao;

import java.util.List;

import com.org.mytest.vo.Student;



public interface StudentDao { 
	// 增加操作  
    public void insert(Student stu) throws Exception ;  
    // 修改操作  
    public void update(Student stu) throws Exception ;  
    // 删除操作  
    public void delete(int userid) throws Exception ;  
    // 按ID查询操作  
    public Student queryById(int userid) throws Exception ;  
    // 查询全部  
    public List queryAll() throws Exception ;  

}
