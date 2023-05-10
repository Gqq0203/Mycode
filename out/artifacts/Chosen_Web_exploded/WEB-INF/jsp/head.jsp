<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/2
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
                    Admin
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
</body>
</html>
