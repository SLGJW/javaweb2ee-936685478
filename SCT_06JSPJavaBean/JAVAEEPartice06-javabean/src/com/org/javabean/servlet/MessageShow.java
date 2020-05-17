package com.org.javabean.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.javabean.vo.Student;

/**
 * Servlet implementation class MessageShow
 */
@WebServlet("/MessageShow")
public class MessageShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//设置服务器给客户端响应的内容类型，指定编码方式解决返回给客户端中文乱码的问题
        request.setCharacterEncoding("UTF-8");//解决Post请求的中文乱码问题
//        HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String [] hobby = request.getParameterValues("hobby");
		String date = request.getParameter("date");
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		student.setSex(sex);
		student.setHobby(hobby);
		student.setDate(date);
//		session.setAttribute("student", student);
		request.setAttribute("student", student);
//		response.sendRedirect("messageShow2.jsp");
		request.getRequestDispatcher("messageShow2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
