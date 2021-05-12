package com.example.demo.filter;

import java.io.IOException;

import com.example.demo.constants.Const;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SecurityFilter implements Filter
{

    private static String[] suffix;

    public SecurityFilter()
    {

        if (suffix == null)
        {
            suffix = new String[Const.STATICS.length];

            for (int i = 0; i < Const.STATICS.length; i++)
            {
                suffix[i] = StringUtils.join(new String[] {
                        Const.HOST_URL, Const.STATICS[i], ""
                }, Const.SLASH);
            }
        }
    }

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain
    ) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        String url = req.getRequestURL().toString();
        System.out.println(url);

        if (!StringUtils.startsWithAny(url, suffix))
        {// 不是静态资源，需要权限
            Cookie[] cookie = req.getCookies();

        }
        chain.doFilter(request, response);
    }
}
