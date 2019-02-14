<%--
  Created by IntelliJ IDEA.
  User: 83513
  Date: 2019/2/12
  Time: 16:04
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
  <title>首页</title>
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
      <img src="${path}/img/logo.png" alt="顶部logo">
    </a>
  </h1>
  <div class="nav">
    <a href="IndexServlet?param=main" class="active">文章</a>
    <a href="IndexServlet?param=leacots">留言</a>
    <a href="IndexServlet?param=about">关于</a>
  </div>
  <ul class="layui-nav header-down-nav">
    <li class="layui-nav-item"><a href="IndexServlet?param=main" class="avtive">文章</a></li>
    <li class="layui-nav-item"><a href="IndexServlet?param=leacots">留言</a></li>
    <li class="layui-nav-item"><a href="IndexServlet?param=about">关于</a></li>
  </ul>
  <p class="welcome-text">
    欢迎来到<span class="name">我</span>的博客~
  </p>
</div>
<!--首页图片-->
<div class="banner">
  <div class="cont w1000">
    <div class="title">
      <h3>MY<br />BLOG</h3>
      <h4>Hello World...</h4>
    </div>
  </div>
</div>
<!--内容部分-->
<div class="content whisper-content">
  <div class="cont">
    <div class="whisper-list">
      <c:forEach var="article" items="${requestScope['articlePage']['articles']}">
        <!-- 单个博客内容 -->
        <div class="item-box">
          <div class="item">
            <div class="whisper-artical-title">
              <h3>${article['title']}</h3>
            </div>
            <div class="whisper-title">
              <i class="layui-icon layui-icon-date"></i><span class="date">${article['timeString']}</span>
            </div>
            <p class="text-cont">
                ${article['summary']}
            </p>
            <div class="op-list">
              <p class="like"><i class="layui-icon layui-icon-praise"></i><span>${article['commentCount']}</span></p>
              <p class="edit"><i class="layui-icon layui-icon-reply-fill"></i><span>${article['likeCount']}</span></p>
              <p class="off"><span><a href="ArticleServlet?param=detail&articleId=${article['id']}">更多>>></a></span></p>
            </div>
          </div>
        </div>
      </c:forEach>
      <!-- 单个文章结束 -->
    </div>
    <!--底部分页-->
    <div class="layui-btn-group" style="color: #fff;text-align: center;">
      <c:if test="${requestScope.articlePage['currentPage'] == 1}">
        <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">首页</button>
        <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">上一页</button>
      </c:if>
      <c:if test="${requestScope.articlePage['currentPage'] != 1}">
        <button class="layui-btn layui-btn-sm layui-btn-primary"><a href="IndexServlet?param=main&currentPage=1">首页</a></button>
        <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                href="IndexServlet?param=main&currentPage=${requestScope.articlePage['currentPage'] - 1}">上一页</a></button>
      </c:if>
      <c:forEach var="cursor" begin="1" step="1" end="${requestScope.articlePage['totalPage']}">
        <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                href="IndexServlet?param=main&currentPage=${cursor}">${cursor}</a></button>
      </c:forEach>
      <button class="layui-btn layui-btn-sm layui-btn-primary">......</button>
      <c:if test="${requestScope.articlePage['currentPage'] < requestScope.articlePage['totalPage']}">
        <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                href="IndexServlet?param=main&currentPage=${requestScope.articlePage['currentPage'] + 1}">下一页</a></button>
        <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                href="IndexServlet?param=main&currentPage=${requestScope.articlePage['totalPage']}">尾页</a></button>
      </c:if>
      <c:if test="${requestScope.articlePage['currentPage'] >= requestScope.articlePage['totalPage']}">
        <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">下一页</button>
        <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">尾页</button>
      </c:if>
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
