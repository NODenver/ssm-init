<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<body>
<h2>Hello World!</h2>
<h2>登陆成功</h2>
<a href="<%=basePath%>/shiro/logout">注销</a>
</body>
</html>
