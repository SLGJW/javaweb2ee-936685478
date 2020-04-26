package com.org.test3.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterTest
 */
@WebFilter("/*")
public class FilterTest implements Filter {

    /**
     * Default constructor. 
     */
    public FilterTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
				HttpServletRequest req = (HttpServletRequest)request;
				HttpServletResponse resp = (HttpServletResponse) response;
				// pass the request along the filter chain
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String path = req.getRequestURI();
				if (path.indexOf("/LoginFilter.jsp") > -1 || path.indexOf("/ErrorView") > -1) {
					chain.doFilter(req, resp);
					return;
				}else {
					if ("user".equals(username) && "456".equals(password) || req.getSession().getAttribute("username") != null) {
						chain.doFilter(req, resp);
					}
					else{
						resp.sendRedirect("ErrorView");
					}
				}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
