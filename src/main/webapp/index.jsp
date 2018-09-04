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
      <th> <a href="/user/signIn?username=ceshi2&&password=2222">用户登录</a></th>
      <th> <a href="/user/signUp?username=ceshi2&&password=2222">用户注册</a></th>
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
      <th> <a href="/address/create?detail=ceshi&&userId=2">添加地址</a></th>
      <td><a href="/address/queryAll">查询所有地址</a></td>
      <td><a href="/address/addressUser/1">查询指定地址及对应的用户</a></td>
    </tr>

    <tr>
      <th>课程表</th>
      <td><a href="/course/queryAll">查询所有课程</a></td>
      <td><a href="/course/courseStudents/1">查询所有地址</a></td>
    </tr>

    <tr>
      <th>图书表</th>
      <td><a href="/book/create?title=ceshi&&price=11.20&&pubTime=2015-01-02&&amount=100&&userId=3">添加一本图书</a></td>
      <td><a href="/book/queryAll">查询学生名下的全部图书</a></td>
      <td><a href="/book/queryById/1">根据id查询图书</a></td>
      <td><a href="/book/update?id=1&&title=ceshi1&&price=11.20&&pubTime=2015-01-02&&amount=100">修改图书</a></td>
      <td><a href="/book/remove/1">根据id删除图书</a></td>
      <td><a href="/book/removeBooks">删除多本图书</a></td>
      <td><a href="/book/queryAllBooks">查询全部图书</a></td>
      <td><a href="/book/queryUserByBookId/1">查询读过某书的全部学生</a></td>
    </tr>




  </table>
  <%--<td><a href="/book?action=queryById&id=${book.id}">EDIT</a></td>--%>
  </body>
</html>
