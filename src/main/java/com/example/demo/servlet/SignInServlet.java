package com.example.demo.servlet;

import java.io.IOException;
import com.example.demo.service.CookieService;
import com.example.demo.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class SignInServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private UserService service = new UserService();
    private CookieService cService = new CookieService();

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
        long id = Long.parseLong(request.getParameter("id"));
        String pwd = (String)request.getParameter("pwd");
        long res = service.SignIn(id, pwd);

        if (res == id)
        {
            Cookie[] cookies = cService.set(id);

            for (Cookie c: cookies)
            {
                response.addCookie(c);
            }
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
