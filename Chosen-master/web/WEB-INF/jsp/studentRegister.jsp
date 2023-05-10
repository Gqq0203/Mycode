<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/2
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String msg=(String) session.getAttribute("msg");%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>

</head>
<body>
<jsp:include page="leftStudent.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">个人相关记录</a>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>记录编号</th>
                    <th>志愿</th>
                    <th>教师编号</th>
                    <th>教师姓名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="register" items="${registerList}" varStatus="loop">
                    <tr>
                        <td>${register.rid}</td>
                        <td>第${register.able}志愿</td>
                        <td>${register.tno}</td>
                        <td>${teachersList[loop.count-1].tname}</td>
                        <td>
                            <label>
                                <c:if test="${register.state==0}">尚未同意</c:if>
                                <c:if test="${register.state==1}">已同意</c:if>
                                <c:if test="${register.state==2}">已被拒绝</c:if>
                            </label>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

<%
    if(msg != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=msg%>");                                            // 弹出错误信息
</script>
<%
        session.setAttribute("msg",null);
    }
%>
</html>
