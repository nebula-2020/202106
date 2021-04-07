package com.example.demo.servlet;

import java.io.*;

import com.alibaba.fastjson.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet
{

    public SignUpServlet()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    private static String path = "./jsonDB.json";

    @Override
    protected void
            doPost(HttpServletRequest request, HttpServletResponse response)
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
        JSONObject json = JSONObject.parseObject(read);
        if(json==null) {
            json=new JSONObject();
        }
        if (!json.containsKey(id))
        {
            json.put(id, pwd);
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(json.toJSONString());
            bw.flush();
            bw.close();
            fw.close();
            request.getRequestDispatcher("/html/home.html")
                    .forward(request, response);
        }
        else
        {
        }
    }
}
