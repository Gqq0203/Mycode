<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/1
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-sm-5" style="margin: 80px 450px;">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">学生注册</a>
        </div>
        <form action="${pageContext.request.contextPath}/student/userStudent" method="post">
            <div class="form-group">
                <label>学生编号</label>
                <input type="text" name="sno" class="form-control" required>
            </div>
            <div class="form-group">
                <label>学生密码</label>
                <input type="text" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label>学生姓名</label>
                <input type="text" name="sname" class="form-control" required>
            </div>
            <div class="form-group">
                <label>学生年龄</label>
                <input type="text" name="age" class="form-control" required>
            </div>
            <div class="form-group">
                <label>学生年级</label>
                <input type="text" name="grade" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="注册">
            </div>
        </form>
    </div>
</div>
</body>
</html>
