<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/8
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告管理</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">公告列表</a>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>公告内容</th>
                        <th>公布时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="notice" items="${list}" >
                        <tr>
                            <td>${notice.id}</td>
                            <td>${notice.message}</td>
                            <td>${notice.time.toLocaleString()}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/toUpdateNotice?id=${notice.id}">更改</a>
                                <a href="${pageContext.request.contextPath}/admin/deleteNotice?id=${notice.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
