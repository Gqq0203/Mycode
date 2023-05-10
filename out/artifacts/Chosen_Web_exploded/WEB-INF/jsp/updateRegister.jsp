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
        <a class="panel-title">更改记录表</a>
    </div>
        <form action="${pageContext.request.contextPath}/register/updateRegister" method="post">
            <input type="hidden" name="rid" value="${register.rid}">
            <div class="form-group">
                <label>学生编号</label>
                <input type="text" name="sno" class="form-control" value="${register.sno}" required>
            </div>
            <div class="form-group">
                <label>教师编号</label>
                <input type="text" name="tno" class="form-control" value="${register.tno}" required>
            </div>
            <div class="form-group">
                <label>志愿</label>
                <input type="text" name="able" class="form-control" value="${register.able}" required>

            </div>
            <input type="hidden" name="able" class="form-control" value="${register.state}">
<%--            <div class="form-group">--%>
<%--                <label>状态:&nbsp</label>--%>
<%--                <input type="radio" name="state" value=0 checked/>&nbsp&nbsp<label>未通过</label>--%>
<%--                &nbsp--%>
<%--                <input type="radio" name="state" value=1  />&nbsp&nbsp<label>已通过</label>--%>
<%--            </div>--%>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>
</body>
</html>
