package com.example.demo.servlet;

import java.io.IOException;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SignInServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		Iterator<String> iterator= request.getParameterNames().asIterator();
		while(iterator.hasNext()) {
			String name=iterator.next();
			System.out.println(name);
		}
		String id = (String) request.getParameter("id");
		String pwd = (String) request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		boolean succeed = (id != null && pwd != null && id.compareTo("管理员") == 0 && pwd.compareTo("root") == 0);
        if(succeed)
        {
            request.getRequestDispatcher("./html/home.html").forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
