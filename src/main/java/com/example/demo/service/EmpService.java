package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.bean.EmpBean;
import com.example.demo.dao.EmpDao;

import org.apache.commons.lang3.StringUtils;

public class EmpService
{
    private EmpDao ud = new EmpDao();

    public List<EmpBean> gets(int start, int count)
    {
        List<EmpBean> ret = new LinkedList<EmpBean>();

        try
        {
            ret = ud.get(start, count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public EmpBean get(int id)
    {
        EmpBean ret = null;

        if (id > 0)
        {
            ret = ud.get(id);
        }
        return ret;
    }

    public EmpBean update(EmpBean bean)
    {
        EmpBean ret = null;

        if (bean.getEmpno() > 0
                && !StringUtils.isAnyBlank(bean.getEname(), bean.getJob()))
        {
            ret = ud.update(bean);
        }
        return ret;
    }

    public EmpBean add(EmpBean bean)
    {
        EmpBean ret = null;

        if (bean != null && bean.getEmpno() > 0
                && !StringUtils.isAnyBlank(bean.getEname(), bean.getJob()))
        {
            ret = ud.add(bean);
        }
        return ret;
    }

    public boolean delete(int id)
    {
        return ud.delete(id);
    }
}
