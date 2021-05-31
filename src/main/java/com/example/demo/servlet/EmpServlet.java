package com.example.demo.servlet;

import java.io.*;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.EmpBean;
import com.example.demo.service.EmpService;

// import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class EmpServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private EmpService service = new EmpService();

    public EmpServlet()
    {
    }

    /**
     * 删除。
     */
    @Override
    protected void
            doDelete(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        int no = Integer.valueOf(request.getParameter("empno"));
        boolean res = service.delete(no);
        JSONObject ret = new JSONObject();
        ret.put("effect", Integer.valueOf(res ? 1 : 0));
        response.getWriter().write(ret.toString());
    }

    /**
     * 更新。
     */
    @Override
    protected void
            doPut(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        JSONObject json = getJSON(request);
        EmpBean bean = j2b(json);
        bean = service.update(bean);

        if (bean != null)
        {
            String res = JSONObject.toJSONString(bean);
            response.getWriter().write(res.toString());
        }
        else
        {
            response.getWriter().write(new JSONObject().toString());
        }
    }

    /**
     * 获取。
     */

    @Override
    protected void
            doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        int start = Integer.valueOf(request.getParameter("start"));
        int size = Integer.valueOf(request.getParameter("size"));
        List<EmpBean> beans = service.gets(start, size);
        System.out.println(beans);
        String res = JSONObject.toJSONString(beans);
        response.getWriter().write(res.toString());
    }

    /**
     * 增加。
     */
    @Override
    protected void
            doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        JSONObject json = getJSON(request);
        EmpBean bean = j2b(json);
        bean = service.add(bean);

        if (bean != null)
        {
            String res = JSONObject.toJSONString(bean);
            response.getWriter().write(res.toString());
        }
        else
        {
            response.getWriter().write(new JSONObject().toString());
        }
    }

    private JSONObject getJSON(HttpServletRequest request) throws IOException
    {
        BufferedReader br = request.getReader();
        String str, json = "";

        while ((str = br.readLine()) != null)
        {
            json += str;
        }
        br.close();
        JSONObject ret = JSON.parseObject(json);
        return ret;
    }

    private EmpBean j2b(JSONObject json)
    {
        EmpBean bean = null;

        try
        {
            int empno = json.getIntValue("empno");
            String ename = json.getString("ename");
            int mgr = json.getIntValue("mgr");
            int hiredate = json.getIntValue("hiredate");
            float sal = json.getFloatValue("sal");
            float comm = json.getFloatValue("comm");
            int deptno = json.getIntValue("deptno");
            String job = json.getString("job");
            bean = new EmpBean(
                    empno, ename, job, mgr, hiredate, sal, comm, deptno
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return bean;
    }
}
