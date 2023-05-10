<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/1
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="leftTeacher.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">修改个人信息</a>
        </div>
        <form action="${pageContext.request.contextPath}/teacher/modifyTeahcer" method="post">
            <input type="hidden" name="tno" value="${teacher.tno}">
            <div class="form-group">
                <label>教师姓名</label>
                <input type="text" name="tname" class="form-control" value="${teacher.tname}" required>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="text" name="password" class="form-control" value="${teacher.password}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
