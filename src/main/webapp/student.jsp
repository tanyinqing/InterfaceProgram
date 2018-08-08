<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/7 0007
  Time: 下午 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="/user/signIn" method="post">
    <input name="username" placeholder="Username" value="tan"><br>
    <input type="password" name="password" placeholder="Password" value="123"><br>
    <input type="submit" value="用户登录">
  </form>

  <form action="/user/signUp" method="post" >
    <input name="username" placeholder="username" value="tan"> <br>
    <input type="password" name="password" placeholder="Passsword" value="123"><br>
    <input type="submit" value="用户注册">
  </form>

  <p>
    <a href="/sign_up.jsp">注册 </a>
  </p>
  <hr>
  <p><a href="/user/queryAll">列出所有的用户，并查处他对应的图书</a></p>
  <p><a href="/user/queryAllUsers">同时列出所有的用户，和对应的所有图书</a></p>
  <p><a href="/book/queryAllBooks">查询所有图书</a></p>
  <p><a href="/user/toCreateAddress">添加地址</a></p>

  <p><a href="/user/queryAll1">列出所有的用户</a></p>
  <p><a href="/address/queryAll">列出所有的地址</a></p>

  <hr>
  <p><a href="/student/queryAll">列出所有的学生</a></p>
  <p><a href="/student/queryAllJson">列出所有的学生 返回json数据</a></p>
  <p><a href="/course/queryAll">列出所有的课程</a></p>
  </body>
</html>
