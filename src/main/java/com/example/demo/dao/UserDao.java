package com.example.demo.dao;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.*;
import com.example.demo.util.*;
import java.time.LocalDateTime;

public class UserDao
{
    private UserBean getBean(Iterator<Map<String, Object>> res)
    {
        UserBean ret = null;

        if (res.hasNext())
        {
            Map<String, Object> rs = res.next();
            System.out.println("DBResult:" + JSON.toJSON(rs));
            long resId = (long)rs.get("id");
            String n = (String)rs.get("name");
            String pwd = (String)rs.get("password");
            String phone = (String)rs.get("phone");
            LocalDateTime createTime = (LocalDateTime)rs.get("create_time");
            boolean del = (Boolean)rs.get("del");
            ret = new UserBean(resId, n, phone, createTime, pwd, del);
        }
        System.out.print(JSON.toJSONString(ret));
        return ret;
    }

    public UserBean addUser(String name, String phone, String password)
    {
        UserBean ret = null;

        try
        {
            int lines = DBUtil.executeUpdate(
                    "insert user set phone=?, name=?, password=?;", phone, name,
                    password
            );

            if (lines > 0)
            {
                ret = getUser(phone);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public UserBean getUser(String phone)
    {
        UserBean ret = null;

        try
        {
            Iterator<Map<String, Object>> res = DBUtil.executeQuery(
                    "select * from `user` where `phone`=? limit 1;", phone
            );
            ret = getBean(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public UserBean getUser(long id)
    {
        UserBean ret = null;

        try
        {
            Iterator<Map<String, Object>> res = DBUtil
                    .executeQuery("select * from user where id=? limit 1;", id);
            ret = getBean(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
}
