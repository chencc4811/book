<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
</head>
<body>
<jsp:include   page="head.jsp" flush="true"/>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>电话</th>
        <th>操作</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.phone}</td>
            <td><a href="${pageContext.request.contextPath}/admin/deleteuser/${user.userId}"><button class="layui-btn">删除</button></a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>

</body>
</html>
