package com.example.demo.service;

import java.util.*;

import com.example.demo.constants.Const;

import jakarta.servlet.http.Cookie;

public class CookieService
{
    public Cookie[] set(long id)
    {
        List<Cookie> cookies = new LinkedList<>();
        Cookie idCookie =
                new Cookie(Const.COOKIE_ID, Long.valueOf(id).toString());
        idCookie.setMaxAge(Const.COOKIE_TIME);
        cookies.add(idCookie);
        return cookies.toArray(new Cookie[cookies.size()]);
    }

    public HashMap<String, String> get(Cookie[] cookies)
    {
        HashMap<String, String> ret = new HashMap<>();

        if (cookies != null)
        {

            for (Cookie cookie: cookies)
            {

                if (cookie != null)
                {
                    ret.put(cookie.getName(), cookie.getValue());
                }
            }
        }
        return ret;
    }
}
