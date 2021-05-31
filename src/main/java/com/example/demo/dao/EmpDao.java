package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.EmpBean;
import com.example.demo.util.DBUtil;

public class EmpDao
{
    private EmpBean getBean(Map<String, Object> rs)
    {
        EmpBean ret = null;

        try
        {
            int empno = (Integer)rs.get("empno");
            String ename = (String)rs.get("ename");
            String job = (String)rs.get("job");
            int mgr = (Integer)rs.get("mgr");
            int hiredate = (Integer)rs.get("hiredate");
            float sal = (Float)rs.get("sal");
            float comm = (Float)rs.get("comm");
            int deptno = (Integer)rs.get("deptno");
            ret = new EmpBean(
                    empno, ename, job, mgr, hiredate, sal, comm, deptno
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    private List<EmpBean> getBeans(List<Map<String, Object>> res)
    {
        ArrayList<EmpBean> ret = new ArrayList<>();

        for (Map<String, Object> e: res)
        {
            ret.add(getBean(e));
        }
        System.out.print("RESULT: " + JSON.toJSONString(ret));
        return ret;
    }

    public EmpBean add(EmpBean bean)
    {
        EmpBean ret = null;

        if (bean != null)
        {

            try
            {
                String sql =
                        "insert emp set empno=?, ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=?;";
                int lines = DBUtil.executeUpdate(
                        sql, bean.getEmpno(), bean.getEname(), bean.getJob(),
                        bean.getMgr(), bean.getHiredate(), bean.getSal(),
                        bean.getComm(), bean.getDeptno()
                );

                if (lines > 0)
                {
                    ret = get(bean.getEmpno());
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public EmpBean get(int id)
    {
        EmpBean ret = null;

        if (id > 0)
        {

            try
            {
                String sql = "select * from emp where empno=? limit 1;";
                List<Map<String, Object>> res = DBUtil.executeQuery(sql, id);

                if (res.size() > 0)
                {
                    ret = getBean(res.get(0));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public List<EmpBean> get(int index, int count)
    {
        List<EmpBean> ret = new ArrayList<EmpBean>();

        try
        {
            String sql = "select * from emp ORDER BY `empno` LIMIT ?,?;";
            List<Map<String, Object>> res =
                    DBUtil.executeQuery(sql, index, count);
            ret = getBeans(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public EmpBean update(EmpBean bean)
    {
        EmpBean ret = null;

        if (bean != null)
        {

            try
            {
                String sql =
                        "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?;";
                int lines = DBUtil.executeUpdate(
                        sql, bean.getEname(), bean.getJob(), bean.getMgr(),
                        bean.getHiredate(), bean.getSal(), bean.getComm(),
                        bean.getDeptno(), bean.getEmpno()
                );

                if (lines > 0)
                {
                    ret = get(bean.getEmpno());
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public boolean delete(int id)
    {
        boolean ret = false;

        if (id > 0)
        {

            try
            {
                String sql = "DELETE FROM emp where empno=?;";
                int res = DBUtil.executeUpdate(sql, id);
                ret = res > 0;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
