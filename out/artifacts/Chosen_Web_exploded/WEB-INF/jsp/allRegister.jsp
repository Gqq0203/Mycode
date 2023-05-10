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
    <title>学生信息展示</title>
</head>
<body>
<%--<jsp:include page="head.jsp"/>--%>
<jsp:include page="left.jsp"/>

<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">最终记录列表</a>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>记录编号</th>
                    <th>学生编号</th>
                    <th>教师编号</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="register" items="${list}">
                    <tr>
                        <td>${register.rid}</td>
                        <td>${register.sno}</td>
                        <td>${register.tno}</td>
                        <td>
                            <c:if test="${register.state==0}">未通过</c:if>
                            <c:if test="${register.state==1}">通过</c:if>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/register/toUpdateRegister/${register.rid}">更改</a> |
                            <a href="${pageContext.request.contextPath}/register/deleteRegister/${register.rid}/${register.sno}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="8">
                        <ul class="pagination">
                            <li><a href="#">«</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">»</a></li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
</body>
</html>
