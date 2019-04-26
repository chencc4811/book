
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



<div class="container-wrap">
    <div class="container container-message container-details container-comment">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h3>${book.bookName}</h3>


                    <img src="${pageContext.request.contextPath}/resources/image/book-icon.jpg"
                         alt="Pic">

                </div>
            </div>
            <form class="layui-form" action="${pageContext.request.contextPath}/detail/comment/${bookId}">
                <div class="layui-form-item layui-form-text">
                    <textarea class="layui-textarea" style="resize:none" placeholder="写点什么啊" name="comment"></textarea>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">评论</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include   page="buttom.jsp" flush="true"/>


<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>


</body>
</html>