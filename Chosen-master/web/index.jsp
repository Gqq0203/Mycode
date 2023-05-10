<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录页面</title>
  <%--<button onclick="${pageContext.request.contextPath}/student/toLoginStudent">进入学生登录页面</button>--%>
  <%--<button><a href="${pageContext.request.contextPath}/teacher/toLoginTeacher">进入教师登录页面</a></button>--%>
  <%--<button><a href="${pageContext.request.contextPath}/admin/toLoginAdmin">进入管理员登录页面</a></button>--%>
  <meta http-equiv=Content-Type content="text/html; charset=utf-8">
  <link href="${pageContext.request.contextPath}/css/style.css"
        type=text/css rel=stylesheet>
  <link href="${pageContext.request.contextPath}/css/boot-crm.css"
        type=text/css rel=stylesheet>
  <script src=
                  "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
  </script>
  <meta content="MSHTML 6.00.2600.0" name=GENERATOR>
  </head>
<style type="text/css">
  body{
    background-image: url(${pageContext.request.contextPath}/img/llxy.png);
    background-repeat: no-repeat; /*避免重复显示图片*/
    background-attachment: fixed; /*设置图片固定*/
    background-size: 100% 100%;"


  }
  button{
    width: 240px;
    line-height: 48px;
    text-align: center;
    font-weight: bold;
    font-size:20px;
    color: #000a08;
    text-shadow:1px 1px 1px #333;
    border-radius: 5px;
    margin:0 20px 20px 0;
    position: relative;
    overflow: hidden;
  }
</style>
  <body>


  <div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">

      <tr align="center" style="width:400px;height: 400px;">

        <td class="login_msg" width="400" align="center" >
          <!-- margin:0px auto; 控制当前标签居中 -->
          <fieldset style="width: 450px; margin: 0px auto;">
            <legend>
              <font style="font-size:15px" face="宋体">
                欢迎使用学业门诊系统
              </font>
            </legend>
            <font color="red">
              <%-- 提示信息--%>
              <span id="message">${msg}</span>
            </font>

            <form>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />

              <button onclick="window.location.href='${pageContext.request.contextPath}/student/toLoginStudent'" type="button">进入学生登录页面</button>

              <br />
              <button onclick="window.location.href='${pageContext.request.contextPath}/teacher/toLoginTeacher'" type="button">进入教师登录页面</button>

              <br />
              <button onclick="window.location.href='${pageContext.request.contextPath}/admin/toLoginAdmin'" type="button">进入管理员登录页面</button>
            </form>
          </fieldset>
        </td>
      </tr>

    </table>
  </div>
  </body>
</html>
