<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/1
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>教师登录界面</title>

    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <%
        String msg=(String) session.getAttribute("loginError");
        if( msg!= null) {
    %>
    <script type="text/javascript" language="javascript">
        alert("<%=msg%>");                                            // 弹出错误信息
    </script>
    <%
            session.removeAttribute("loginError");
        }
    %>
</head>
<body>
<!-- 登录表单 -->
<form style="margin-left:500px;margin-top:200px;" action="${pageContext.request.contextPath}/teacher/loginTeacher" method="post">
    <h2>教师登录</h2>
    <div class="centent" style="margin: auto"  >
        <div class="form-group">
            <label for="user" stype="display:inline;">账户：</label>
            <input type="text" class="form-control" id="user" name="tno" style="display:inline;width:200px;"autocomplete="off" />
        </div>
        <div class="form-group">
            <label for="password" style="display:inline;">密码：</label>
            <input type="password" class="form-control" id="password" name="password" style="display:inline;width:200px;"autocomplete="off" />
        </div>
<%--        <div class="button" style="display: flex;flex-wrap: nowrap;align-items: center;justify-content: space-around">--%>
            <button type="submit" class="btn btn-primary" onclick="login()">登录</button>
            <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/teacher/toUserTeacher'">注册</button>
<%--        </div>--%>
    </div>


</form>
</body>
</html>