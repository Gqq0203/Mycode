<%@ page import="com.wzx.Pojo.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/2
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<% Student student=(Student) session.getAttribute("student"); %>
<!-- 导航栏部分 -->
<div class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav nav-stacked navbar-right">
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-tasks"></span>
                    <i class="badge">2</i>
                </a>
            </li>
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-bell"></span>
                    <i class="badge">1</i>
                </a>
            </li>
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-envelope"></span>
                    <i class="badge">1</i>
                </a>
            </li>
            <li>
                <a href="#" data-toggle="dropdown">
                    <small>Welcome</small>
                    <%=student.getSname()%>
                    <span class="caret"></span>
                </a>
                <ul class="nav nav-pills nav-stacked dropdown-menu">
                    <li class="active">
                        <a href="#">
                            <span class="glyphicon glyphicon-cog"></span> Setting
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-user"></span> Profile
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <span class="glyphicon glyphicon-off"></span> Logout
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div class="col-sm-2">
    <div class="panel-group" id="box">
        <div class="panel panel-success">
            <div class="panel-heading">
                <a href="#collapseA" data-parent="#box" data-toggle="collapse" class="panel-title">导师管理</a>
            </div>
            <div class="panel-collapse collapse in" id="collapseA">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="${pageContext.request.contextPath}/student/toStudentView?sno=<%=student.getSno()%>">选择导师</a></li>
                        <li><a href="${pageContext.request.contextPath}/student/toStudentRegisted?sno=<%=student.getSno()%>">已选导师</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <a href="#collapseB" data-parent="#box" data-toggle="collapse" class="panel-title">个人管理</a>
            </div>
            <div class="panel-collapse collapse" id="collapseB">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="${pageContext.request.contextPath}/student/toModifyStudent?sno=<%=student.getSno()%>">修改信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading">
                <a href="#collapseC" data-parent="#box" data-toggle="collapse" class="panel-title">公告管理</a>
            </div>
            <div class="panel-collapse collapse" id="collapseC">
                <div class="panel-body">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="${pageContext.request.contextPath}/admin/toStudentNotice">查看公告</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
