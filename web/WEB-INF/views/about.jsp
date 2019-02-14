<%--
  Created by IntelliJ IDEA.
  User: 83513
  Date: 2019/2/13
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>关于</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/main.css">
</head>
<body>
<!--头部-->
<div class="header">
    <div class="menu-btn">
        <div class="menu"></div>
    </div>
    <h1 class="logo">
        <a href="UserServlet?param=login">
            <span>MYBLOG</span>
            <img src="${path}/img/logo.png">
        </a>
    </h1>
    <div class="nav">
        <a href="IndexServlet?param=main">文章</a>
        <a href="IndexServlet?param=leacots">留言</a>
        <a href="IndexServlet?param=about" class="active">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
        <li class="layui-nav-item"><a href="IndexServlet?param=main">文章</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=leacots">留言</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=about" class="active">关于</a></li>
    </ul>
    <p class="welcome-text">
        欢迎来到<span class="name">我</span>的博客~
    </p>
</div>
<!--中间内容部分-->

<div class="about-content">
    <div class="w1000">
        <div class="item info">
            <div class="title">
                <h3>我的介绍</h3>
            </div>
            <div class="cont">
                <img src="${path}/img/avatar.jpeg">
                <div class="per-info">
                    <p>
                        <span class="name">吕从雷</span><br />
                        <span class="age">22岁</span><br />
                        <span class="Career">大四狗</span><br />
                        <span class="interest">足球、乒乓球</span>
                    </p>
                </div>
            </div>
        </div>
        <div class="item tool">
            <div class="title">
                <h3>我的技能</h3>
            </div>
            <div class="layui-fluid">
                <div class="layui-row">
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
                        <div class="cont-box">
                            <img src="${path}/img/vue.png">
                        </div>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
                        <div class="cont-box">
                            <img src="${path}/img/java.png">
                        </div>
                    </div>
                    <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
                        <div class="cont-box">
                            <img src="${path}/img/python.jpeg">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item contact">
            <div class="title">
                <h3>联系方式</h3>
            </div>
            <div class="cont">
                <img src="${path}/img/QRCode.png">
                <div class="text">
                    <p class="WeChat">微信：<span>13290243215</span></p>
                    <p class="qq">qq：<span>835132735</span></p>
                    <p class="iphone">电话：<span>13290243215</span></p>
                </div>
            </div>
        </div>
    </div>
</div>

<!--底部-->
<div class="footer-wrap">
    <div class="footer w1000">
        <div class="qrcode">
            <img src="${path}/img/QRCode.png">
        </div>
        <div class="practice-mode">
            <img src="${path}/img/down_img.jpg">
            <div class="text">
                <h4 class="title">我的联系方式</h4>
                <p>微信<span class="WeChat">13290243215</span></p>
                <p>邮箱<span class="email">835132735@qq.com</span></p>
                <p>Github<span class="email">https://github.com/lvconl</span></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/layui/layui.js"></script>
<script>
    layui.config({
        base: '${path}/js/util/'
    }).use(['element', 'laypage', 'jquery', 'menu'], function () {
        element = layui.element, laypage = layui.laypage, $ = layui.$, menu = layui.menu;
        menu.init();
    })
</script>
</body>
</html>
