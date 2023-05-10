<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/1
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>教师信息展示</title>
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">教师列表</a>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>教师编号</th>
                        <th>密码</th>
                        <th>姓名</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="teacher" items="${list}">
                        <tr>
                            <td>${teacher.tno}</td>
                            <td>${teacher.password}</td>
                            <td>${teacher.tname}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/teacher/toUpdateTeacher?id=${teacher.tno}">更改</a> |
                                <a href="${pageContext.request.contextPath}/teacher/deleteTeacher/${teacher.tno}">删除</a>
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
