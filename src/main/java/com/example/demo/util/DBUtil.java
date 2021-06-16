package com.example.demo.util;

import java.sql.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public abstract class DBUtil
{
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static final String DB_NAME = "demo2106db";
    public static final String QUEST = "?";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME
            + "?characterEncoding=UTF-8";
    private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    static
    {

        try
        {
            Class.forName(CLASSNAME);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接。
     */
    public static Connection Connect()
    {
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关数据库链接。
     */
    public static void
            CloseDatabase(Connection con, PreparedStatement pstm, ResultSet rs)
    {

        if (con != null)
        {

            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (pstm != null)
        {

            try
            {
                pstm.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (rs != null)
        {

            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Map<String, Object>>
            executeQuery(String sql, Object... objs)
                    throws IllegalArgumentException
    {

        if (StringUtils.isBlank(sql) || objs == null)
        {
            throw new NullPointerException();
        }
        int paramCount = StringUtils.countMatches(sql, DBUtil.QUEST);

        if (objs.length != paramCount)
        {
            throw new IllegalArgumentException();
        }
        Connection con = DBUtil.Connect();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Map<String, Object>> ret = new ArrayList<>();

        try
        {
            pstm = con.prepareStatement(sql);

            for (int i = 1; i <= paramCount; i++)
            {
                pstm.setObject(i, objs[i - 1]);
            }

            rs = pstm.executeQuery();

            if (rs != null)
            {
                ResultSetMetaData meta = rs.getMetaData();
                int colCount = meta.getColumnCount();

                while (rs.next())
                {
                    HashMap<String, Object> map = new HashMap<>();

                    for (int i = 1; i <= colCount; i++)
                    {
                        map.put(meta.getColumnName(i), rs.getObject(i));
                    }
                    ret.add(map);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.CloseDatabase(con, pstm, rs);
        }
        return ret;
    }

    public static int executeUpdate(String sql, Object... objs)
            throws IllegalArgumentException
    {

        if (StringUtils.isBlank(sql) || objs == null)
        {
            throw new NullPointerException();
        }
        int paramCount = StringUtils.countMatches(sql, DBUtil.QUEST);

        if (objs.length != paramCount)
        {
            throw new IllegalArgumentException();
        }
        Connection con = DBUtil.Connect();
        PreparedStatement pstm = null;
        int ret = 0;

        try
        {
            pstm = con.prepareStatement(sql);

            for (int i = 1; i <= paramCount; i++)
            {
                pstm.setObject(i, objs[i - 1]);
            }
            ret = pstm.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.CloseDatabase(con, pstm, null);
        }
        return ret;
    }
}