<%--
  Created by IntelliJ IDEA.
  User: 83513
  Date: 2019/2/13
  Time: 19:55
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
    <title>留言</title>
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
        <a href="IndexServlet?param=leacots" class="active">留言</a>
        <a href="IndexServlet?param=about">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
        <li class="layui-nav-item"><a href="IndexServlet?param=main">文章</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=leacots" class="active">留言</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=about">关于</a></li>
    </ul>
    <p class="welcome-text">
        欢迎来到<span class="name">我</span>的博客~
    </p>
</div>
<!--中间内容部分-->

<div class="content whisper-content leacots-content">
    <div class="cont w1000">
        <div class="whisper-list">
            <div class="item-box">
                <div class="review-version">
                    <div class="form-box">
                        <img class="banner-img" src="${path}/img/liuyan.jpg">
                            <form class="layui-form layui-form-pane" action="LeacotServlet?param=add" method="post" style="margin-top: 20px;">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="email" required  lay-verify="email" placeholder="请留下邮箱" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">留言</label>
                                    <div class="layui-input-block">
                                        <textarea name="content" placeholder="既然来了，就说几句" class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block" style="text-align: right;">
                                        <button class="layui-btn definite">提交</button>
                                    </div>
                                </div>
                            </form>
                    </div>
                    <div class="volume">
                        全部留言 <span>${requestScope.leacotPage['totalCount']}</span>
                    </div>
                    <div class="list-cont">
                        <!--单个留言-->
                        <c:forEach var="leacot" items="${requestScope.leacots}">
                        <div class="cont">
                            <div class="img">
                                <img src="${path}/img/header.png" alt="">
                            </div>
                            <div class="text">
                                <p class="tit"><span class="name">${leacot['email']}</span><span class="data">${leacot['createAt']}</span></p>
                                <p class="ct">${leacot['content']}</p>
                            </div>
                        </div>
                        </c:forEach>
                        <!--留言结束-->
                    </div>
                    <!--底部分页-->
                    <div class="layui-btn-group" style="color: #fff;text-align: center;">
                        <c:if test="${requestScope.leacotPage['currentPage'] == 1}">
                            <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">首页</button>
                            <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">上一页</button>
                        </c:if>
                        <c:if test="${requestScope.leacotPage['currentPage'] != 1}">
                            <button class="layui-btn layui-btn-sm layui-btn-primary"><a href="IndexServlet?param=main&currentPage=1">首页</a></button>
                            <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                    href="IndexServlet?param=leacots&currentPage=${requestScope.leacotPage['currentPage'] - 1}">上一页</a></button>
                        </c:if>
                        <c:forEach var="cursor" begin="1" step="1" end="${requestScope.leacotPage['totalPage']}">
                            <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                    href="IndexServlet?param=leacots&currentPage=${cursor}">${cursor}</a></button>
                        </c:forEach>
                        <button class="layui-btn layui-btn-sm layui-btn-primary">......</button>
                        <c:if test="${requestScope.leacotPage['currentPage'] < requestScope.leacotPage['totalPage']}">
                            <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                    href="IndexServlet?param=leacots&currentPage=${requestScope.leacotPage['currentPage'] + 1}">下一页</a></button>
                            <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                    href="IndexServlet?param=leacots&currentPage=${requestScope.leacotPage['totalPage']}">尾页</a></button>
                        </c:if>
                        <c:if test="${requestScope.leacotPage['currentPage'] >= requestScope.leacotPage['totalPage']}">
                            <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">下一页</button>
                            <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">尾页</button>
                        </c:if>
                    </div>
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
    }).use(['element', 'laypage', 'jquery', 'form','menu'], function () {
        element = layui.element, laypage = layui.laypage, $ = layui.$, menu = layui.menu, layui.form;
        menu.init();
    })
</script>
</body>
</html>
