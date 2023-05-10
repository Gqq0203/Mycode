<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/8
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加公告</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">添加公告</a>
        </div>
        <form action="${pageContext.request.contextPath}/admin/addNotice" method="post">
            <div class="form-group">
                <label>公告内容</label>
                <textarea rows="5" name="message" style="width:400px"></textarea>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="添加">
            </div>
        </form>
    </div>
</div>
</body>
</html>
