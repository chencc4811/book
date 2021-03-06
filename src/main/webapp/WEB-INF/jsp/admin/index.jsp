<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>怀德二手书交易系统后台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
</head>
<body>

<jsp:include   page="head.jsp" flush="true"/>

<div class="fly-main" style="overflow: hidden;">

<table class="layui-table">
    <thead>
    <tr>
        <th colspan="2" scope="col">服务器信息</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th width="30%">服务器计算机名</th>
        <td><span id="lbServerName">http://127.0.0.1/</span></td>
    </tr>
    <tr>
        <td>服务器IP地址</td>
        <td>192.168.1.1</td>
    </tr>
    <tr>
        <td>服务器域名</td>
        <td>x.xuebingsi.com</td>
    </tr>
    <tr>
        <td>服务器端口 </td>
        <td>80</td>
    </tr>
    <tr>
        <td>服务器IIS版本 </td>
        <td>Microsoft-IIS/6.0</td>
    </tr>
    <tr>
        <td>本文件所在文件夹 </td>
        <td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
    </tr>
    <tr>
        <td>服务器操作系统 </td>
        <td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
    </tr>
    <tr>
        <td>系统所在文件夹 </td>
        <td>C:\WINDOWS\system32</td>
    </tr>
    <tr>
        <td>服务器脚本超时时间 </td>
        <td>30000秒</td>
    </tr>
    <tr>
        <td>服务器的语言种类 </td>
        <td>Chinese (People's Republic of China)</td>
    </tr>
    <tr>
        <td>.NET Framework 版本 </td>
        <td>2.050727.3655</td>
    </tr>
    <tr>
        <td>服务器当前时间 </td>
        <td>2017-01-01 12:06:23</td>
    </tr>
    <tr>
        <td>服务器IE版本 </td>
        <td>6.0000</td>
    </tr>
    <tr>
        <td>服务器上次启动到现在已运行 </td>
        <td>7210分钟</td>
    </tr>
    <tr>
        <td>逻辑驱动器 </td>
        <td>C:\D:\</td>
    </tr>
    <tr>
        <td>CPU 总数 </td>
        <td>4</td>
    </tr>
    <tr>
        <td>CPU 类型 </td>
        <td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
    </tr>
    <tr>
        <td>虚拟内存 </td>
        <td>52480M</td>
    </tr>
    <tr>
        <td>当前程序占用内存 </td>
        <td>3.29M</td>
    </tr>
    <tr>
        <td>Asp.net所占内存 </td>
        <td>51.46M</td>
    </tr>
    <tr>
        <td>当前Session数量 </td>
        <td>8</td>
    </tr>
    <tr>
        <td>当前SessionID </td>
        <td>gznhpwmp34004345jz2q3l45</td>
    </tr>
    <tr>
        <td>当前系统用户名 </td>
        <td>NETWORK SERVICE</td>
    </tr>
    </tbody>
</table>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>

</body>
</html>
