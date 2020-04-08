<%--
  Created by IntelliJ IDEA.
  User: 20829
  Date: 2020/4/8
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=basePath%>/shiro/login" method="post">
    <input type="text" name="username"><br>
    <input name="password" type="password"><br>
    <button type="submit">登录</button>
</form>
</body>
</html>
