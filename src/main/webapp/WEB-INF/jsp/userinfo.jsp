<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我发布的书籍</title>
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
        <th>书名</th>
        <th>描述</th>
        <th>价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bookName}</td>
            <td>${book.bookDesc}</td>
            <td>${book.bookPrice}</td>
            <td><a href="${pageContext.request.contextPath}/book/edit1/${book.bookId}"><button class="layui-btn">编辑</button></a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>



<jsp:include   page="buttom.jsp" flush="true"/>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</body>
</html>
