<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="fly-header layui-bg-black">
    <ul class="layui-nav" lay-filter="">
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/list">书籍管理</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">会员管理</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="${pageContext.request.contextPath}/to/adminadduser">添加会员</a></dd>
                <dd><a href="${pageContext.request.contextPath}/admin/userlist">删除会员</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">管理员管理</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="${pageContext.request.contextPath}/to/adminaddadmin">添加管理员</a></dd>
                <dd><a href="${pageContext.request.contextPath}/admin/adminlist">删除管理员</a></dd>
            </dl>
        </li>
    </ul>



    <ul class="layui-nav fly-nav-user">
        <!-- 未登入的状态 -->

        <c:if test="${sessionScope.loginAdmin.adminId==null}">
            <li class="layui-nav-item">
                <a  href="${pageContext.request.contextPath}/to/adminlogin">登入</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.loginAdmin.adminId!=null}">
            <li class="layui-nav-item">
                <a href="#" >欢迎：${sessionScope.loginAdmin.adminName}</a>
            </li>
        </c:if>
        <li class="layui-nav-item">
            <a href="javascript:void (0);" onclick="loginOut()">退出</a>
        </li>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>


    </ul>



</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>


<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
        var element = layui.element;

        //…
    });
</script>

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
