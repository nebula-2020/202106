package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserBean;
import com.example.demo.util.DBUtil;

import org.apache.commons.lang3.StringUtils;

public class UserDao extends Dao<UserBean, Long>
{
    private UserBean getBean(Map<String, Object> rs)
    {
        UserBean ret = null;

        try
        {
            long resId = (long)rs.get("id");
            String n = (String)rs.get("name");
            String pwd = (String)rs.get("password");
            String phone = (String)rs.get("phone");
            LocalDateTime createTime = (LocalDateTime)rs.get("create_time");
            boolean del = (Boolean)rs.get("del");
            ret = new UserBean(resId, n, phone, createTime, pwd, del);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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

    public UserBean add(String name, String phone, String password)
    {
        UserBean ret = null;

        try
        {
            String sql = "insert user set phone=?, name=?, password=?;";
            int lines = DBUtil.executeUpdate(sql, phone, name, password);

            if (lines > 0)
            {
                ret = get(phone);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public UserBean get(String phone)
    {
        UserBean ret = null;

        try
        {
            String sql = "select * from `user` where `phone`=? limit 1;";
            Iterator<Map<String, Object>> res = DBUtil.executeQuery(sql, phone);

            if (res.hasNext())
            {
                ret = getBean(res.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public List<UserBean> get(long... ids)
    {
        List<UserBean> ret = null;

        try
        {
            String sql = "select * from user where id in (?);";
            String str = StringUtils.join(ids, ',');
            Iterator<Map<String, Object>> res = DBUtil.executeQuery(sql, str);
            ret = getBeans(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public UserBean get(Long id)
    {
        UserBean ret = null;

        if (id != null && id > 0)
        {

            try
            {
                String sql = "select * from user where id=? limit 1;";
                Iterator<Map<String, Object>> res =
                        DBUtil.executeQuery(sql, id);

                if (res.hasNext())
                {
                    ret = getBean(res.next());
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public Iterator<UserBean> get(Collection<Long> primaryKeys)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBean add(UserBean obj)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<UserBean> add(Collection<UserBean> objs)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBean update(Long primaryKey, UserBean obj)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<UserBean> update(Map<Long, UserBean> map)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int delete(Long primaryKey)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Collection<Long> primaryKeys)
    {
        // TODO Auto-generated method stub
        return 0;
    }
}
