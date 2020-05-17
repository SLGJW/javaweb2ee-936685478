package com.org.mytest.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.mytest.jdbc.JdbcTest;
import com.org.mytest.ov.Student;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
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
				String info = request.getParameter("info");
				ArrayList<Student> list = null;
				try {
					JdbcTest jdbc = new JdbcTest();
					if (info.indexOf("s") != -1) {
						list = jdbc.termFind(info, "","2048-12-12","3");
					}else if (info.indexOf("-") != -1) {
						list = jdbc.termFind("", "",info,"3");
					}else if (info.equals("ÄÐ")) {
						list = jdbc.termFind("", "","2048-12-12","1");
					}else if (info.equals("Å®")) {
						list = jdbc.termFind("", "","2048-12-12","0");
					}else {
						list = jdbc.termFind("", info,"2048-12-12","3");
					}
					request.setAttribute("list", list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("info1", info);
				request.getRequestDispatcher("Select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
