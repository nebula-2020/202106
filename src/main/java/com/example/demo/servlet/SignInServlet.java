package com.example.demo.servlet;

import java.io.IOException;
import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class SignInServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public SignInServlet()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void
            doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        long id = Long.parseLong(request.getParameter("id"));
        String pwd = (String)request.getParameter("pwd");
        UserDao ud = new UserDao();
        UserBean user = ud.getUser(id);

        if (user != null && user.getPassword().compareTo(pwd) == 0)
        {
            request.getRequestDispatcher("./html/home.html")
                    .forward(request, response);
        }
        else
        {
            response.getWriter().write("<h1>:(<h1><h2>用户名或密码错误</h2>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void
            doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
