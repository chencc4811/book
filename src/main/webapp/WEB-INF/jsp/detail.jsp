<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>书籍详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mian.css">

</head>
<body class="lay-blog">

<jsp:include   page="head.jsp" flush="true"/>


<div class="container-wrap">
    <div class="container container-message container-details">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h1><a href="details.html">${bookDetail.bookName}</a></h1>

                    <h3 style="color: #40AFFE">交易地点：${bookDetail.area.areaName}</h3>
                    <h3 style="color: red">价格：${bookDetail.bookPrice}￥</h3>
                    <h3 style="color: darkslategray">我的联系方式：${bookDetail.user.phone}</h3>
                    <div>
                        <p3>描述：${bookDetail.bookDesc}</p3>

                    </div>
                    <img src="${pageContext.request.contextPath}/resources/image/${bookDetail.bookImg}" alt="">

                </div>
            </div>
            <a name="comment"> </a>
            <div class="comt layui-clear">
                <a href="${pageContext.request.contextPath}/book/buy/${sessionScope.loginUser.userId}/${bookDetail.userId}/${bookDetail.bookId}"><button class="layui-btn" id="button-buy">我要了</button></a>
                <a href="${pageContext.request.contextPath}/detail/toComm/${bookDetail.bookId}" class="pull-right">写评论</a>

            </div>
            <div id="LAY-msg-box">
                <c:forEach items="${comments}" var="comment">
                    <div class="info-item">
                            <%--<img class="info-img" src="../res/static/images/info-img.png" alt="">--%>
                        <div class="info-text">
                            <p class="title count">
                                <span class="name">${comment.user.userName}:</span>

                            </p>
                            <p class="info-intr">${comment.comment}</p>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </div>
</div>

<jsp:include   page="buttom.jsp" flush="true"/>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/resources/js/'
    }).use('blog');
</script>



</body>
</html>