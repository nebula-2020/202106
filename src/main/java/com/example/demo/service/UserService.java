package com.example.demo.service;

import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;

import org.apache.commons.lang3.StringUtils;

public class UserService
{
    public long SignIn(long id, String password)
    {
        long ret = 0;

        if (id > 0 && !StringUtils.isBlank(password))
        {
            UserDao ud = new UserDao();
            UserBean user = ud.get(id);

            if (user != null && user.getId() > 0
                    && user.getPassword().compareTo(password) == 0)
            {
                ret = user.getId();
            }
        }
        return ret;
    }

    public long SignUp(String name, String phone, String password)
    {
        long ret = 0;

        if (!StringUtils.isAnyBlank(name, phone, password))
        {
            UserDao ud = new UserDao();
            UserBean user = ud.add(name, phone, password);

            if (user != null)
            {
                ret = user.getId();
            }
        }
        return ret;
    }
}
