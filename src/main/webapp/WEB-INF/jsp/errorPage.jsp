
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mian.css">

</head>
<body class="lay-blog">
<jsp:include   page="head.jsp" flush="true"/>

<div>
    <p1 style="color:red;text-align: center;" >${msg}</p1>

</div>
<div>
    <img src="${pageContext.request.contextPath}/resources/image/error.jpg" width="500" height="500">

</div>



<jsp:include   page="buttom.jsp" flush="true"/>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>


</body>
</html>