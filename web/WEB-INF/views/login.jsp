<%--
  Created by IntelliJ IDEA.
  User: 83513
  Date: 2019/2/13
  Time: 10:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>登录</title>
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
        <a href="IndexServlet?param=about">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
        <li class="layui-nav-item"><a href="IndexServlet?param=main">文章</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=leacots">留言</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=about">关于</a></li>
    </ul>
    <p class="welcome-text">
        欢迎来到<span class="name">我</span>的博客~
    </p>
</div>
<!--中间部分-->
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md7" style="margin-top: 150px;margin-bottom: 150px;">
            <!-- 登录表单 -->
            <form class="layui-form layui-form-pane" action="UserServlet?param=login" method="post">
                <div class="layui-form-mid" style="color: #FF5722;">${requestScope.msg}</div>
                <div class="layui-form-item">
                    <label class="layui-form-label "><i class="layui-icon layui-icon-username"></i></label>
                    <div class="layui-input-block">
                        <input type="text" name="username" autocomplete="off" placeholder="请输入账号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-block">
                        <input type="password" name="password" autocomplete="off" placeholder="请输入密码"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="submit" class="layui-btn"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-md5">
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
