<%--
  Created by IntelliJ IDEA.
  User: 83513
  Date: 2019/2/13
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>${requestScope.article['title']}</title>
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
<!--内容部分-->
<div class="content whisper-content leacots-content details-content">
    <div class="cont w1000">
        <div class="whisper-list">
            <div class="item-box">
                <div class="review-version">
                    <div class="form-box">
                        <div class="article-cont">
                            <div class="title">
                                <h3>${requestScope.article['title']}</h3>
                                <p class="cont-info"><span class="data">${requestScope.article['timeString']}</span><span class="types">${requestScope.blogType['typeName']}</span></p>
                            </div>
                            ${requestScope.article['content']}
                        </div>
                        <div class="form">
                            <form class="layui-form" action="CommentServlet?param=add&articleId=${requestScope.article['id']}" method="post">
                                <div class="layui-form-item layui-form-text">
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
                    </div>
                    <div class="volume">
                        全部留言 <span>${requestScope.commentPage['totalCount']}</span>
                    </div>
                    <div class="list-cont">
                        <!-- 单个评论 -->
                        <c:forEach var="comment" items="${requestScope['comments']}">
                        <div class="cont">
                            <div class="img">
                                <img src="${path}/img/header.png" alt="">
                            </div>
                            <div class="text">
                                <p class="tit"><span class="name">网友</span><span class="data">${comment['createAt']}</span></p>
                                <p class="ct">${comment['content']}</p>
                            </div>
                        </div>
                        </c:forEach>
                        <!-- 评论结束 -->
                        <!-- 底部分页 -->
                        <div class="layui-btn-group" style="text-align: center; margin-top: 10px;">
                            <c:if test="${requestScope.commentPage['currentPage'] == 1}">
                                <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">首页</button>
                                <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">上一页</button>
                            </c:if>
                            <c:if test="${requestScope.commentPage['currentPage'] != 1}">
                                <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                        href="ArticleServlet?param=detail&articleId=${requestScope['article']['id']}&currentPage=1">首页</a></button>
                                <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                        href="ArticleServlet?param=detail&articleId=${requestScope['article']['id']}&currentPage=${requestScope.commentPage['currentPage'] - 1}">上一页</a>
                                </button>
                            </c:if>
                            <c:forEach var="cursor" begin="1" step="1" end="${requestScope.commentPage['totalPage']}">
                                <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                        href="ArticleServlet?param=detail&articleId=${requestScope['article']['id']}&currentPage=${cursor}">${cursor}</a></button>
                            </c:forEach>
                            <button class="layui-btn layui-btn-sm layui-btn-primary">......</button>
                            <c:if test="${requestScope.commentPage['currentPage'] < requestScope.commentPage['totalPage']}">
                                <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                        href="ArticleServlet?param=detail&articleId=${requestScope['article']['id']}&currentPage=${requestScope.commentPage['currentPage'] + 1}">下一页</a>
                                </button>
                                <button class="layui-btn layui-btn-sm layui-btn-primary"><a
                                        href="ArticleServlet?param=detail&articleId=${requestScope['article']['id']}&currentPage=${requestScope.commentPage['totalPage']}">尾页</a>
                                </button>
                            </c:if>
                            <c:if test="${requestScope.commentPage['currentPage'] >= requestScope.commentPage['totalPage']}">
                                <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">下一页</button>
                                <button class="layui-btn layui-btn-sm layui-btn-primary layui-btn-disabled">尾页</button>
                            </c:if>
                        </div>
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
    }).use(['element', 'laypage', 'jquery', 'menu'], function () {
        element = layui.element, laypage = layui.laypage, $ = layui.$, menu = layui.menu;
        menu.init();
    })
</script>
</body>
</html>
