package com.example.demo.servlet;

import java.io.*;
import java.util.*;

import com.alibaba.fastjson.*;
import com.example.demo.bean.EmpBean;
import com.example.demo.service.EmpService;

import org.apache.commons.lang3.StringUtils;

// import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class EmpServlet extends HttpServlet
{
    private static final String SUCCEED = "succeed";
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
        System.out.println("DO DELETE...");
        String jsonStr = request.getParameter("empnos");
        int res = 0;
        JSONArray ids = JSON.parseArray(jsonStr);
        System.out.println(jsonStr);
        Enumeration<String> strs = request.getAttributeNames();

        while (strs.hasMoreElements())
        {
            System.out.println(strs.nextElement());
        }

        if (ids != null)
        {
            int len = ids.size();

            for (int i = 0; i < len; i++)
            {
                res += service.delete(ids.getInteger(i)) ? 1 : 0;
            }
            JSONObject ret = new JSONObject();
            ret.put("effect", res);
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(ret.toString());
        }
        else
        {
            response.setStatus(400);
        }
    }

    /**
     * 更新。
     */
    @Override
    protected void
            doPut(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException
    {
        System.out.println("DO PUT...");
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
            response.setContentType("application/json; charset=utf-8");
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
        System.out.println("DO GET...");
        int start = Integer.valueOf(request.getParameter("page"));
        int size = Integer.valueOf(request.getParameter("limit"));
        List<EmpBean> beans = new LinkedList<>();
        String name = null;

        if (request.getParameterMap().containsKey("name"))
        {
            name = request.getParameter("name");
        }

        if (name != null && StringUtils.isNotBlank(name))
        {
            System.out.println(name);
            beans = service.gets(start, size, name);
        }
        else
        {
            beans = service.gets(start, size);
        }
        JSONObject res = packOfGet(0, SUCCEED, beans.size(), beans);
        response.setContentType("application/json; charset=utf-8");
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
        System.out.println("DO POST...");
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
            response.setContentType("application/json; charset=utf-8");
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
        System.out.println(json);
        JSONObject ret = JSON.parseObject(json);
        return ret;
    }

    private JSONObject packOfGet(int code, String msg, int count, Object data)
    {
        JSONObject ret = new JSONObject();
        ret.put("code", code);
        ret.put("msg", msg);
        ret.put("count", count);
        ret.put("data", data);
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
            long hiredate = json.getLongValue("hiredate");
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
