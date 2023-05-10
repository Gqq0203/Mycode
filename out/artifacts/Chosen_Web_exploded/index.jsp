<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/1
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h3>
    <a href="${pageContext.request.contextPath}/student/toLoginStudent">进入学生登录页面</a>
  </h3>
  <h3>
    <a href="${pageContext.request.contextPath}/teacher/toLoginTeacher">进入教师登录页面</a>
  </h3>
  <h3>
    <a href="${pageContext.request.contextPath}/admin/toLoginAdmin">进入管理员登录页面</a>
  </h3>
  </body>
</html>
