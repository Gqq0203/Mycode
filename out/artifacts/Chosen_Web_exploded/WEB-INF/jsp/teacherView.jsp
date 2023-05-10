<%@ page import="com.wzx.Pojo.Teacher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/2
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师界面</title>
</head>
<body>
<%
    Teacher teacher=(Teacher) session.getAttribute("teacher");
    String tmsg=(String) session.getAttribute("tmsg");
%>
<jsp:include page="leftTeacher.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">可选学生列表</a>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>志愿</th>
                        <th>学生编号</th>
                        <th>姓名</th>
                    </tr>
                    </thead>
                    <tbody>
<%--                所有与该教师相关的学生志愿都在registerList集合中--%>
                    <c:forEach var="register" items="${registerList}" varStatus="loop">
                        <tr>
                            <td>${register.rid}</td>
                            <td>第${register.able}志愿</td>
                            <td>${register.sno}</td>
                            <td>${studentList[loop.count-1].sname}</td>
                            <c:if test="${register.state==0}">
                                <td>
                                    <a href="${pageContext.request.contextPath}/teacher/addTeacherRegister/<%=teacher.getTno()%>/${register.sno}/${register.rid}/${register.able}">选择</a>
                                    <a href="${pageContext.request.contextPath}/teacher/refuseStudent/${register.rid}/${register.able}">拒绝</a>
                                </td>
                            </c:if>
                            <c:if test="${register.state==2}">
                                <td>已拒绝</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<%
    if(tmsg != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=tmsg%>");                                            // 弹出错误信息
</script>
<%
        session.setAttribute("tmsg",null);
    }
%>
</html>
