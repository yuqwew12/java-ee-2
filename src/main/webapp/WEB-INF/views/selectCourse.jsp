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
    <title>选课</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>
<div class="container">
    <h2>选课</h2>
    <form action="/selectCourse" method="post">
        <c:forEach var="course" items="${courses}">
            <p>课程ID: ${course.id}, 课程名称: ${course.name}, 当前学生数: ${course.currentStudents}, 最大学生数: ${course.maxStudents}</p>
            <c:if test="${course.currentStudents < course.maxStudents}">
                <input type="checkbox" name="courseId[]" value="${course.id}">
                ${course.name} (剩余名额: ${course.maxStudents - course.currentStudents})<br>
            </c:if>
        </c:forEach>

        <button type="submit">选择</button>
    </form>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <h3>您的选择</h3>
    <ul>
        <c:forEach var="selection" items="${selections}">
            <li>${selection.courseId}</li>
        </c:forEach>
    </ul>
    <a href="/logout">注销</a>
</div>
</body>
</html>

