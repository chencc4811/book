<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑书籍</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">

</head>
<body>
<jsp:include   page="head.jsp" flush="true"/>

<div class="fly-main">
    <form class="layui-form" action="${pageContext.request.contextPath}/book/update/${book.bookId}" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">书籍名称</label>
            <div class="layui-input-block">
                <input type="text" name="bookName" required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input" value="${book.bookName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">书籍价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input" value="${book.bookPrice}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">分类</label>
            <div class="layui-input-block">
                <select name="areaId" lay-verify="required">

                    <c:forEach items="${areaList}" var="area">
                        <option value="${area.areaId}">${area.areaName}</option>

                    </c:forEach>

                </select>
            </div>
        </div>





        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">书籍描述</label>
            <div class="layui-input-block">
                <textarea name="bookDesc" placeholder="${book.bookDesc}" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<jsp:include   page="buttom.jsp" flush="true"/>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<%--<script>--%>
    <%--layui.use('upload', function(){--%>
        <%--var upload = layui.upload;--%>

        <%--//执行实例--%>
        <%--var uploadInst = upload.render({--%>
            <%--elem: '#test1' //绑定元素--%>
            <%--,url: '/upload/' //上传接口--%>
            <%--,done: function(res){--%>
                <%--//上传完毕回调--%>
            <%--}--%>
            <%--,error: function(){--%>
                <%--//请求异常回调--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return true;
        });
    });
</script>


</body>


</html>