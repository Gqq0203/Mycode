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
            <a class="panel-title">学生列表</a>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>学生编号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>年级</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${list}">
                        <tr>
                            <td>${student.sno}</td>
                            <td>${student.password}</td>
                            <td>${student.sname}</td>
                            <td>${student.age}</td>
                            <td>${student.grade}</td>
                            <td>
                                <c:if test="${student.state==0}">未选</c:if>
                                <c:if test="${student.state==1}">已选</c:if>
                            </td>
                            <td>
                            <a href="${pageContext.request.contextPath}/student/toUpdateStudent?id=${student.sno}">更改</a> |
                            <a href="${pageContext.request.contextPath}/student/deleteStudent/${student.sno}">删除</a>
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
