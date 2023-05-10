<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/14
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置参数</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">更改参数</a>
        </div>
        <form action="${pageContext.request.contextPath}/teacher/updateTeacher" method="post">
            <div class="form-group">
                <label>每个教师的学生上限</label>
                <input type="text" name="password" class="form-control" value="${}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
