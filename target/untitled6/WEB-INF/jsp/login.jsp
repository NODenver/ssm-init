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
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <div id="form_div">
        <form class="form-signin" method="post" action="<%=basePath%>/shiro/login">
            <h2 class="form-signin-heading" align="center">Luke 后台管理</h2>
            <label for="inputUsername" class="sr-only">username</label>
            <input type="username" id="inputUsername" name="username" class="form-control" placeholder="username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox">
                <label>
                    <input type="radio"  name="rememberMe" value="true"> Remember me
                    <input type="radio"  name="rememberMe" value="false" style="display: none" checked="checked">
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>


</div> <!-- /container -->

<style>
    #form_div {
        width: 300px;
        height: 200px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 200px;
    }
</style>
</body>
</html>