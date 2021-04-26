package com.example.demo.servlet;

import java.io.*;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GetUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public GetUserServlet()
    {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void
            doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        int count = Integer.parseInt(request.getParameter("count"));
        int start = Integer.parseInt(request.getParameter("start"));
        int step = Integer.parseInt(request.getParameter("step"));
        long[] reqs = new long[count];

        for (int i = 0, c = 0; c < count; c++, i += step)
        {
            reqs[i] = i + start;
        }
        UserDao ud = new UserDao();
        List<UserBean> users = ud.getUser(reqs);

        if (users != null && users.size() > 0)
        {
            HashMap<String, String> res = new HashMap<>();

            for (UserBean bean: users)
            {
                res.put(Long.toString(bean.getId()), bean.getName());
            }
            response.getWriter().write(JSON.toJSONString(res));
        }
        else
        {
            response.getWriter().write("非法访问");
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
