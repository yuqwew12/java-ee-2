<%--
  Created by IntelliJ IDEA.
  User: yuchengyu
  Date: 2024/12/12
  Time: 下午5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选课结果</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>
<div class="container">
    <h2>选课结果</h2>
    <ul>
        <c:forEach var="selection" items="${selections}">
            <li>${selection.courseId}</li>
        </c:forEach>
    </ul>
    <a href="/selectCourse">返回选课页面</a>
    <a href="/logout">注销</a>
</div>
</body>
</html>


