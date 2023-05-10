<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/8
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公告</title>
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">更改公告</a>
        </div>
        <form action="${pageContext.request.contextPath}/admin/updateNotice" method="post">
            <input type="hidden" name="id" value="${notice.id}">
            <div class="form-group">
                <label>公告内容</label>
                <input type="text" name="message" class="form-control" value="${notice.message}" required>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="修改">
            </div>
        </form>
    </div>
</div>

</body>
</html>
