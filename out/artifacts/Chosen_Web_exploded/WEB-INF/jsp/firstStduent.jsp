<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/3
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一志愿</title>
</head>
<body>
<jsp:include page="leftStudent.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">第一志愿</a>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>学生编号</th>
                        <th>教师编号</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="teacher" items="${list}">
                        <tr>
                            <td>${teacher.tno}</td>
                            <td>${teacher.tname}</td>

                            <td>
                                <a href="${pageContext.request.contextPath}/student/addStudentRegister/<%=student.getSno()%>/${teacher.tno}">选择</a>
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
