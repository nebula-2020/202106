package com.example.demo.dao;

import java.sql.*;

import com.example.demo.bean.UserBean;
import com.example.demo.util.DBUtil;

public class UserDao
{
    public long addUser(String name, String password)
    {
        Connection con = DBUtil.Connect();
        PreparedStatement pstm = null;
        ResultSet res = null;
        long ret = 0;

        try
        {
            pstm = con.prepareStatement("insert user set name=?, password=?;");
            pstm.setString(1, name);
            pstm.setString(2, password);
            ret = pstm.executeUpdate();

            if (ret > 0)
            {
                res = pstm.getGeneratedKeys();
                res.next();
                ret = res.getLong("id");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.CloseDatabase(con, pstm, null);
        }
        return ret;
    }

    public UserBean getUser(long id)
    {
        Connection con = DBUtil.Connect();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        UserBean ret = null;

        try
        {
            pstm = con
                    .prepareStatement("select * from user where id=? limit 1;");
            pstm.setLong(1, id);
            rs = pstm.executeQuery();

            if (rs.next())
            {
                long resId = rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                Timestamp createTime = rs.getTimestamp("create_time");
                boolean del = rs.getBoolean("del");
                ret = new UserBean(resId, name, createTime, password, del);
            }
            System.out.println("DBResult:" + rs);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.CloseDatabase(con, pstm, rs);
        }
        return ret;
    }
}
