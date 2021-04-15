package com.example.demo.util;

import java.sql.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public final class DBUtil
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

    public static Iterator<Map<String, Object>>
            execUpdate(String sql, Object... objs)
                    throws IllegalArgumentException
    {

        if (StringUtils.isAllBlank(sql) || objs == null)
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
                pstm.setObject(i, objs[i]);
            }
            pstm.execute();
            rs = pstm.getResultSet();
            ResultSetMetaData meta = rs.getMetaData();

            while (rs.next())
            {
                HashMap<String, Object> map = new HashMap<>();

                for (int i = 0; i < paramCount; i++)
                {
                    map.put(meta.getColumnName(i), rs.getObject(i));
                }
                ret.add(map);
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
            DBUtil.CloseDatabase(con, pstm, null);
        }
        return ret.iterator();
    }
}