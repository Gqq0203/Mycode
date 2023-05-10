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
            <a class="panel-title">教师注册</a>
        </div>
        <form action="${pageContext.request.contextPath}/teacher/userTeacher" method="post">
            <div class="form-group">
                <label>教师编号</label>
                <input type="text" name="tno" class="form-control" required>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="text" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" name="tname" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="注册">
            </div>
        </form>
    </div>
</div>
</body>
</html>
