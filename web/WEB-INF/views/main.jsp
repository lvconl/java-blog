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
    <title>${requestScope.title}</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/main.css">
    <script type="text/javascript" src="${path}/js/jquery.3.2.1.min.js"></script>
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
        <a href="IndexServlet?param=main" class="active">文章</a>
        <a href="IndexServlet?param=leacots">留言</a>
        <a href="IndexServlet?param=about">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
        <li class="layui-nav-item"><a href="IndexServlet?param=main" class="active">文章</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=leacots">留言</a></li>
        <li class="layui-nav-item"><a href="IndexServlet?param=about">关于</a></li>
    </ul>
</div>
<!--中间部分-->
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md9">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">文章管理</li>
                    <li>评论管理</li>
                    <li>新增文章</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">内容1</div>
                    <div class="layui-tab-item">内容2</div>
                    <div class="layui-tab-item">
                        <form class="layui-form layui-form-pane" action="ArticleServlet?param=add" method="post">
                            <div class="layui-form-item">
                                <label class="layui-form-label">文章标题</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题..." autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">文章摘要</label>
                                <div class="layui-input-block">
                                    <textarea name="summary" placeholder="请输入内容..." class="layui-textarea"></textarea>
                                </div>
                            </div>
                            <div id="editor" style="margin-top: 20px;"></div>
                            <textarea id="text" name="content" style="display: none;"></textarea>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <c:forEach var="blogType" items="${requestScope.blogTypes}">
                                        <input type="radio" name="typeId" value="${blogType['id']}" title="${blogType['typeName']}">
                                    </c:forEach>
                                </div>
                            </div>
                            <input type="submit" class="layui-btn layui-btn-fluid" style="margin-top: 10px;" value="提交">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
        </div>
    </div>
</div>
<script type="text/javascript" src="${path}/layui/layui.js"></script>
<script src="${path}/js/wangEditor.min.js" type="text/javascript"></script>
<script>
    layui.config({
        base: '${path}/js/util/'
    }).use(['element', 'laypage', 'jquery', 'menu', 'form'], function () {
        element = layui.element, laypage = layui.laypage, $ = layui.$, menu = layui.menu, form = layui.form;
        menu.init();
    })
</script>
<script type="text/javascript">
    window.onload = function () {
        var E = window.wangEditor;
        var editor = new E("#editor");
        var $text = $('#text');
        editor.customConfig.onchange = function (html) {
            $text.val(html);
        };
        editor.create();
        $text.val(editor.txt.html());
    }
</script>
</body>
</html>
