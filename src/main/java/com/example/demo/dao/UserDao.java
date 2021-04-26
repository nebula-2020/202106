package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserBean;
import com.example.demo.util.DBUtil;

import org.apache.commons.lang3.StringUtils;

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

    private List<UserBean> getBeans(Iterator<Map<String, Object>> res)
    {
        ArrayList<UserBean> ret = new ArrayList<>();

        if (res.hasNext())
        {
            Map<String, Object> rs = res.next();
            long resId = (long)rs.get("id");
            String n = (String)rs.get("name");
            String pwd = (String)rs.get("password");
            String phone = (String)rs.get("phone");
            LocalDateTime createTime = (LocalDateTime)rs.get("create_time");
            boolean del = (Boolean)rs.get("del");
            ret.add(new UserBean(resId, n, phone, createTime, pwd, del));
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

    public List<UserBean> getUser(long... ids)
    {
        List<UserBean> ret = null;

        try
        {
            String str = StringUtils.join(ids, ',');
            Iterator<Map<String, Object>> res = DBUtil
                    .executeQuery("select * from user where id in (?);", str);
            ret = getBeans(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }
}
