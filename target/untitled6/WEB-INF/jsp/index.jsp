<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<body>
<h2>Hello World!</h2>
<h2>登陆成功</h2>
<a href="<%=basePath%>/shiro/logout">注销</a><br>
<a href="<%=basePath%>/user/selectById/1">restful</a> <br>
<button onclick="delete(3)">删除test用户</button>
<shiro:hasRole name="admin">
    <a href="<%=basePath%>/admin/test">Admin Test</a> <br>
</shiro:hasRole>
<shiro:hasAnyRoles name="admin,user">
    <a href="<%=basePath%>/user/test">User Test</a> <br>
</shiro:hasAnyRoles>

<script>
    
</script>
</body>
</html>
