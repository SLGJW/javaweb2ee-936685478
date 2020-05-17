package com.org.mytest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.mytest.jdbc.JdbcTest;
import com.org.mytest.ov.Student;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String sid = request.getParameter("sid");
				String sname = request.getParameter("sname");
				String sbirthday = request.getParameter("sbirthday");
				int ssex = Integer.parseInt(request.getParameter("ssex"));
				HttpSession session = request.getSession();
				String info = "";
				Student student = new Student();
				student.setSid(sid);
				student.setSname(sname);
				student.setSbirthday(sbirthday);
				student.setSsex(ssex);
				try {
					JdbcTest jdbc = new JdbcTest();
					if(jdbc.addMessage(student)) {
						response.sendRedirect("InfoMessage.jsp");
					}else {
						info = "ÃÌº” ß∞‹";
						session.setAttribute("info", info);
						response.sendRedirect("Insert.jsp");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
