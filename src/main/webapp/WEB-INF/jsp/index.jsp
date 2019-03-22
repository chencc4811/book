<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
</head>
<body class="fly-full">
<jsp:include   page="head.jsp" flush="true"/>


<div class="fly-main" style="overflow: hidden;">
    <ul class="fly-case-list">
        <c:forEach items="${bookList}" var="book">
            <li data-id="123">
                <a class="fly-case-img" href="${pageContext.request.contextPath}/detail/book/${book.bookId}" target="_blank" >
                    <img src="${pageContext.request.contextPath}/resources/image/timg.jpg"  alt="二手社区">
                    <cite class="layui-btn layui-btn-primary layui-btn-small">去围观</cite>
                </a>
                <h2><a href="http://fly.layui.com/" target="_blank">${book.bookName}</a></h2>
                <p class="fly-case-desc">${book.bookDesc}</p>
                <h2 style="color: red">￥：${book.bookPrice}</h2>
                <div class="fly-case-info">
                    <a href="../user/home.html" class="fly-case-user" target="_blank"><img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"></a>
                    <p class="layui-elip" style="font-size: 12px;"><span style="color: #666;">${book.user.userName}</span> 2017-11-30</p>

                    <!-- <button class="layui-btn  fly-case-active" data-type="praise">已赞</button> -->
                </div>
            </li>
        </c:forEach>

        <%--<li data-id="123">--%>
            <%--<a class="fly-case-img" href="http://fly.layui.com/" target="_blank" >--%>
                <%--<img src="../../res/images/fly.jpg" alt="二手社区">--%>
                <%--<cite class="layui-btn layui-btn-primary layui-btn-small">去围观</cite>--%>
            <%--</a>--%>
            <%--<h2><a href="http://fly.layui.com/" target="_blank">社区</a></h2>--%>
            <%--<p class="fly-case-desc">Fly 社区是 layui 的官方社区，全站的前端层面基于 Layui 风格编写，轻量而简洁，并且模版已经开源，可用于极简社区模板。</p>--%>
            <%--<div class="fly-case-info">--%>
                <%--<a href="../user/home.html" class="fly-case-user" target="_blank"><img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"></a>--%>
                <%--<p class="layui-elip" style="font-size: 12px;"><span style="color: #666;">贤心</span> 2017-11-30</p>--%>

                <%--<!-- <button class="layui-btn  fly-case-active" data-type="praise">已赞</button> -->--%>
            <%--</div>--%>
        <%--</li>--%>



    </ul>
    <div style="text-align: center;">
        <div class="laypage-main">
            <span class="laypage-curr">1</span>
            <a href="">2</a><a href="">3</a>
            <a href="">4</a>
            <a href="">5</a>
            <span>…</span>
            <a href="" class="laypage-last" title="尾页">尾页</a>
            <a href="" class="laypage-next">下一页</a>
        </div>
    </div>
</div>

<jsp:include   page="buttom.jsp" flush="true"/>



<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>

</body>
</html>
