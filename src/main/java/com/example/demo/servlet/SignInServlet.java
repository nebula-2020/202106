package com.example.demo.servlet;

import java.io.*;
import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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

    private static String path = "./jsonDB.json";

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
        String id = (String)request.getParameter("id");
        String pwd = (String)request.getParameter("pwd");
        File file = new File(path);

        if (!file.exists())
        {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        String read = "{}";
        FileInputStream in = null;

        try
        {
            in = new FileInputStream(file);
            in.read(filecontent);
            read = new String(filecontent, "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

            if (in != null)
            {
                in.close();
            }
        }
        System.out.println(read);
        JSONObject json = JSON.parseObject(read);

        if (id != null && pwd != null && json.containsKey(id)
                && pwd.compareTo(json.getString(id)) == 0)
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
