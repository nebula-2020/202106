package com.example.demo.util;

import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;

public abstract class HttpUtil
{
    public void write(Object obj, PrintWriter writer)
    {

        if (obj != null && writer != null)
        {
            writer.write(JSON.toJSONString(obj));
        }
    }
}
