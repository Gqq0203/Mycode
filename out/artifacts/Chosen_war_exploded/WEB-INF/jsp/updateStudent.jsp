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
    <title>修改学生信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">更改学生信息</a>
        </div>
        <form action="${pageContext.request.contextPath}/student/updateStudent" method="post">
            <input type="hidden" name="sno" value="${student.sno}">
            <div class="form-group">
                <label>学生姓名</label>
                <input type="text" name="sname" class="form-control" value="${student.sname}" required>
            </div>
            <div class="form-group">
                <label>学生密码</label>
                <input type="text" name="password" class="form-control" value="${student.password}" required>
            </div>
            <div class="form-group">
                <label>学生年龄</label>
                <input type="text" name="age" class="form-control" value="${student.age}" required>
            </div>
            <div class="form-group">
                <label>学生年级</label>
                <input type="text" name="grade" class="form-control" value="${student.grade}" required>
            </div>
            <input type="hidden" name="state" class="form-control" value="${student.state}">
<%--            <div class="form-group">--%>
<%--                <label>状态:&nbsp</label>--%>
<%--                <input type="radio" name="state" value=0 checked/>&nbsp&nbsp<label>未选</label>--%>
<%--                &nbsp--%>
<%--                <input type="radio" name="state" value=1  />&nbsp&nbsp<label>已选</label>--%>
<%--            </div>--%>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
