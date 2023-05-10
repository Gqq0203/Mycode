<%@ page import="com.wzx.Pojo.Student" %>
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
    <title>学生界面</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        #twoBox {
            margin: 20px 0px 0px;
            background: #E6E6E6;
            height: 250px;
            width: 310px;
            position: relative;
            display: none;
        }

        #twoBox .twoBox_lever {
            width: 290px;
            height: 230px;
            background: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            position: absolute;
            right: 0;
            top: 0;
            left: 0;
            bottom: 0;
            margin: auto;
        }

        .twoBox_lever_two {
            width: calc(100% - 10px);
            height: calc(100% - 10px);
            padding: 5px;
        }

        .twoBox_lever_two .two_title {
            width: 100%;
            height: 40px;
            background: #E6E6E6;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .twoBox_lever_two .two_title p {
            font-size: 16px;
            color: #000;
            line-height: 40px;
            padding-left: 10px;
            font-weight: 700;
        }
        .twoBox_lever_two form {
            width: calc(100% - 20px);
            margin: 10px;
            border-bottom: 1px solid #ccc;
            height: calc(100% - 100px);
        }

        .twoBox_lever_two form input {
            height: 20px;
            line-height: 20px;
            padding: 0px 10px;
            margin: 5px;
            cursor: pointer;
        }

        .twoBox_lever_two .two_footer {
            height: 40px;
            text-align: right;
            padding-right: 10px;
        }
        .twoBox_lever_two .two_footer button {
            height: 30px;
            background: #E6E6E6;
            border: 1px solid #C7D3E6;
            text-align: center;
            line-height: 30px;
            font-size: 16px;
            color: #000;
            cursor: pointer;
        }
        .twoBox_lever_two .two_footer button:first-of-type {
            width: 120px;
            padding: 0px 10px;
        }
        .twoBox_lever_two .two_footer button:last-of-type {
            width: 50px;
        }
        .show {
            display: block !important;
        }
    </style>
</head>
<body>
<% Student student=(Student) session.getAttribute("student"); %>
<jsp:include page="leftStudent.jsp"/>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading" style="display: flex;flex-wrap: nowrap;align-items: center;justify-content:space-between">
            <a class="panel-title">可选教师列表</a>
            <button id="button">添加志愿</button>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>教师编号</th>
                        <th>姓名</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="teacher" items="${list}">
                        <tr>
                            <td>${teacher.tno}</td>
                            <td>${teacher.tname}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- 第二部分 -->
        <div id="twoBox">
            <div class="twoBox_lever">
                <div class="twoBox_lever_two">
                    <div class="two_title">
                        <p>填选志愿</p>
                    </div>
                    <form name="xc365" action="${pageContext.request.contextPath}/first/addAllRegister" method="post">
                        <input name="sno" value="<%=student.getSno()%>" style="display: none">
                        <label style="float:left">第一志愿：
                            <input type="text" name="tno1" placeholder="请输入教师编号">
                        </label>
                        <label style="float:left">第二志愿：
                            <input type="text" name="tno2" placeholder="请输入教师编号">
                        </label>
                        <label style="float:left">第三志愿：
                            <input type="text" name="tno3" placeholder="请输入教师编号">
                        </label>
                    </form>
                    <div class="two_footer">
                        <button type="submit" onClick="javascript:fsubmit(document.xc365);">提交</button>
                        <button id="cancel_btn">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    window.onload = function () {
        document.getElementById("button").onclick = function () {
            document.getElementById("twoBox").classList.add("show")
        }
        document.getElementById("cancel_btn").onclick=function () {
            document.getElementById("twoBox").classList.remove("show")
        }
    }
    function fsubmit(obj){obj.submit();}
</script>
</html>
