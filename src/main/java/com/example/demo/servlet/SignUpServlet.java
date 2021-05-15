package com.example.demo.servlet;

import java.io.*;

import com.example.demo.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private UserService service = new UserService();

    public SignUpServlet()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    @Override
    protected void
            doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        String name = (String)request.getParameter("name");
        String phone = (String)request.getParameter("phone");
        String pwd = (String)request.getParameter("pwd");
        long id = service.SignUp(name, phone, pwd);

        if (id > 0)
        {
            response.getWriter().write(
                    "<h1>账号为： " + id
                            + "<h1><a href=\"./html/home.html\">转到主页</a>"
            );
        }
        else
        {
            response.getWriter().write("<h1>:(<h1><h2>注册失败</h2>");
        }
    }
}
