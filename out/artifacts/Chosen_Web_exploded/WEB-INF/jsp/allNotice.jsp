<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/8
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有公告</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="col-sm-10">
    <div class="panle panel-success">
        <div class="panel-heading">
            <a class="panel-title">公告列表</a>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>内容</th>
                    <th>公布时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="notice" items="${list}">
                    <tr>
                        <td>${notice.id}</td>
                        <td>${notice.message}</td>
                        <td>${notice.time}</td>
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
