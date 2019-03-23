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

                    <h3>交易地点：${bookDetail.area.areaName}</h3>
                    <h3>价格：${bookDetail.bookPrice}</h3>
                    <h3>我的联系方式：${bookDetail.user.phone}</h3>

                    <p>${bookDetail.bookDesc}</p>
                    <img src="${pageContext.request.contextPath}/resources/image/${bookDetail.bookImg}" alt="">

                </div>
            </div>
            <a name="comment"> </a>
            <div class="comt layui-clear">
                <a href="${pageContext.request.contextPath}/book/buy/${sessionScope.loginUser.userId}/${bookDetail.userId}/${bookDetail.bookId}"><button class="layui-btn">我要了</button></a>
                <a href="${pageContext.request.contextPath}/detail/toComm" class="pull-right">写评论</a>

            </div>
            <div id="LAY-msg-box">
                <div class="info-item">
                    <img class="info-img" src="../res/static/images/info-img.png" alt="">
                    <div class="info-text">
                        <p class="title count">
                            <span class="name">一片空白</span>

                        </p>
                        <p class="info-intr">父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌。</p>
                    </div>
                </div>
                <div class="info-item">
                    <img class="info-img" src="../res/static/images/info-img.png" alt="">
                    <div class="info-text">
                        <p class="title count">
                            <span class="name">一片空白</span>

                        </p>
                        <p class="info-intr">父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌。</p>
                    </div>
                </div>
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