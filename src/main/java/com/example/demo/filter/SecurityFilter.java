package com.example.demo.filter;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.example.demo.constants.Const;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SecurityFilter implements Filter
{

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain
    ) throws IOException, ServletException
    {
        List<String> suffix = new ArrayList<>();

        for (int i = 0; i < Const.STATICS.length; i++)
        {
            suffix.add(StringUtils.join(new String[] {
                    Const.HOST_URL, Const.STATICS[i]
            }, Const.SLASH));
        }
        HttpServletRequest req = (HttpServletRequest)request;
        String url = req.getRequestURL().toString();
        System.out.println(url);
        boolean res = false;

        if (!StringUtils
                .startsWithAny(url, suffix.toArray(new String[suffix.size()])))
        { // 不是静态资源，需要权限
            System.out.println("Verify...");

            try
            {
                Cookie[] cs = req.getCookies();
                HttpSession session = req.getSession(false);

                if (session != null && cs != null)
                {
                    System.out.println("Session exists.");

                    for (Cookie c: cs)
                    {
                        System.out.println(c.getName() + "::" + c.getValue());

                        if (c.getName().compareTo(Const.COOKIE_ID) == 0)
                        {
                            Object v = session.getAttribute(c.getValue());

                            if (v != null && (Boolean)v)
                            {
                                System.out.println("Verify succeed.");
                                res = true;
                                break;
                            }
                        }
                    }
                }
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
            }
        }
        else// 静态资源
        {
            res = true;
        }

        if (res)
        {
            chain.doFilter(request, response);
        }
        else
        {
            System.out.println("Verify Failed:");
            System.out.println("\t" + JSON.toJSONString(req.getCookies()));
            ((HttpServletResponse)response).setStatus(403);
        }
    }
}
