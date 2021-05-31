package com.example.demo.filter;

import java.io.IOException;

import jakarta.servlet.*;

/**
 * 过滤器于服务器关闭时销毁，过滤器不会拦截jsp页面
 */
public class EncodingFilter implements Filter
{

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain
    ) throws IOException, ServletException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        chain.doFilter(request, response);
    }
}
