<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">




</head>
<body>
<jsp:include   page="head.jsp" flush="true"/>


<form class="layui-form" action="${pageContext.request.contextPath}/user/register" method="post" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label  class="layui-form-label">昵称</label>
        <div class="layui-input-inline">
            <input type="text"  name="username" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux" id="namemsg"></div>

    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">手机号</label>
        <div class="layui-input-inline">
            <input type="text" name="phone" required lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" id="ps">
        </div>
        <div class="layui-form-mid layui-word-aux" id="msg">不小于6位</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-inline">
            <input type="password" required lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input" id="ps1" onkeyup="validate()">
        </div>
        <div class="layui-form-mid layui-word-aux" id="msg2"></div>
    </div>


    <%--<div  style="text-align:center">--%>
        <%--<button type="button" class="layui-btn" id="uploadBt" style="text-align:center">--%>
            <%--<i class="layui-icon">&#xe67c;</i>上传头像--%>
        <%--</button>--%>
    <%--</div>--%>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="button-reg">注册</button>
            <button type="reset" class="layui-btn layui-btn-primary" id="b">重置</button>
        </div>
    </div>
</form>

<jsp:include   page="buttom.jsp" flush="true"/>

<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadBt' //绑定元素
            ,url: '/upload/' //上传接口
            ,acceptMime:'image/*'
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
</script>

<script>
    $(function () {
        $('#ps').keyup(function () {
            var len=$(this).val().length;
            if(len<6){
                $('#msg').show();
            }else
            {
                $('#msg').hide();
            }



        })


    })


</script>



<script>
    function validate() {

        var pwd = $("#ps").val();
        var pwd1 = $("#ps1").val();
        <!-- 对比两次输入的密码 -->
        if(pwd == pwd1)
        {
            $("#msg2").text("两次密码相同");

            // $("#xiugai").removeAttr("disabled");
        }
        else {
            $("#msg2").text("两次密码不相同");
            $("#button-reg").attr("disabled", false);
        }
    }
</script>


</body>


</html>