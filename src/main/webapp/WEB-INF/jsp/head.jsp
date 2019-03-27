<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="userId" value="${sessionScope.loginUser}"></c:set>--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <form method="post" action="${pageContext.request.contextPath}/book/search">

        <ul class="layui-nav fly-nav layui-hide-xs">

            <li class="layui-nav-item layui-this">
                <a href="${pageContext.request.contextPath}/book/list">首页</a>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/upload/uploadView"><i
                        class="layui-icon layui-icon-release"></i>发布书籍</a>
            </li>

            <li class="layui-nav-item">

                <input type="text" name="bookName" lay-verify="title" autocomplete="off" class="layui-input">

            </li>
            <li class="layui-nav-item">
                <button class="layui-btn" >搜索</button>
            </li>

        </ul>
        </form>



        <ul class="layui-nav fly-nav-user">
            <!-- 未登入的状态 -->
            <li class="layui-nav-item">
                <a class="iconfont icon-touxiang layui-hide-xs"
                   href="${pageContext.request.contextPath}/book/listById?userId=${sessionScope.loginUser.userId}"></a>
            </li>

            <%--<c:choose>--%>
            <%--<c:when test="${loginUser}" >--%>
            <%--<li class="layui-nav-item">--%>
            <%--<a href="${pageContext.request.contextPath}/to/index">${loginUser}</a>--%>
            <%--</li>--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
            <c:if test="${sessionScope.loginUser.userId==null}">
                <li class="layui-nav-item">
                    <a  href="${pageContext.request.contextPath}/to/login">登入/注册</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.loginUser.userId!=null}">
                <li class="layui-nav-item">
                    <a href="#" >欢迎：${sessionScope.loginUser.userName}</a>
                </li>
            </c:if>
            <li class="layui-nav-item">
                <a href="javascript:void (0);" onclick="loginOut()">退出</a>
            </li>
            <%--</c:otherwise>--%>
            <%--</c:choose>--%>


        </ul>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>

<script>
    function loginOut() {
        alert("确定要退出吗");
        <%--location.replace("${pageContext.request.contextPath}/user/loginOut");--%>
        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/user/loginOut",
            dateType:"json",
            success : function() {
                window.location.reload();

            }});


    }
</script>
</body>
</html>
