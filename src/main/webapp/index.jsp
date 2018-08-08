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
  <table border="1">
    <tr>
      <th>用户表</th>
      <th> <a href="/student.jsp">用户登录</a></th>
      <th> <a href="/student.jsp">用户注册</a></th>
      <td><a href="/book/queryById/${book.id}">注销没有做</a></td>
      <td><a href="/user/queryAll">查询所有用户</a></td>
      <td><a href="/user/queryAllUsers">全部用户及名下图书</a></td>
      <td><a href="/user/queryBooksByUserId/1">指定用户及名下图书</a></td>
      <td><a href="/user/userAddress/2">指定用户及对应地址</a></td>
    </tr>

    <tr>
      <th>学生表</th>
      <td><a href="/student/queryAll">查询所有学生</a></td>
      <td><a href="/student/studentCourses/1">指定学生所学课程</a></td>
    </tr>

    <tr>
      <th>地址表</th>
      <th> <a href="/student.jsp">添加地址</a></th>
      <td><a href="/address/queryAll">查询所有地址</a></td>
      <td><a href="/address/addressUser/1">查询指定地址及对应的用户</a></td>
    </tr>




  </table>
  <%--<td><a href="/book?action=queryById&id=${book.id}">EDIT</a></td>--%>
  </body>
</html>
