<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.example.demo.constants.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <meta name="viewport"
        content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,initial-scale=1" />
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .btn {
            background-color: #08f;
            color: #fff;
            margin: 10px;
            cursor: pointer;
            display: inline-block;
        }

        .input {
            border: #08f solid 1px;
            line-height: 2em;
            min-height: 2em;
        }
    </style>
</head>

<body>
<%
Long userId=null;
Cookie[] cookies = request.getCookies();
 if(cookies !=null){
            for(int i = 0;i < cookies.length;i++){  //遍历cookie对象集合
                if(cookies[i].getName().equals(Const.COOKIE_ID)){
                    userId=Long.parseLong(cookies[i].getValue());
                }
            }
        }
%>
<h1><%= userId %></h1>
    <a href="./html/signIn.html">signIn</a>
    
</body>

</html>