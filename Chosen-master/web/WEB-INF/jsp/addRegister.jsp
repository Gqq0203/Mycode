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
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">添加记录</a>
        </div>
        <form action="${pageContext.request.contextPath}/register/addRegister" method="post">

            <div class="form-group">
                <label>学生编号</label>
                <input type="text" name="sno" class="form-control" required>
            </div>
            <div class="form-group">
                <label>教师编号</label>
                <input type="text" name="tno" class="form-control" required>
            </div>
            <div class="form-group">
                <label>状态</label>
                <input type="text" name="state" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="添加">
            </div>
        </form>
    </div>
</div>
</body>
</html>
