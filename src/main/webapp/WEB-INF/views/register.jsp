<%--
  Created by IntelliJ IDEA.
  User: yuchengyu
  Date: 2024/12/12
  Time: 下午5:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>
<div class="container">
    <h2>注册</h2>
    <form action="/register" method="post">
        <label for="name">用户名:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">注册</button>
    </form>
    <a href="/login">登录</a>
</div>
</body>
</html>

