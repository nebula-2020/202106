package com.example.demo.util;

import java.sql.*;

public final class DBUtil
{
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static final String DB_NAME = "demo2106db";
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
}