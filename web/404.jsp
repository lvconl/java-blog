<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
<!DOCTYPE html>
<html>
<head>
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>
    <script src="${path}/js/preloader.js"></script>
    <link rel="stylesheet" href="${path}/css/style.css">
    <link href='http://fonts.googleapis.com/css?family=Finger+Paint' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="${path}/js/css_browser_selector.js"></script>
    <script type="text/javascript" src="${path}/js/plax.js"></script>
    <script type="text/javascript" src="${path}/js/jquery.spritely-0.6.1.js"></script>
    <script type="text/javascript" src="${path}/js/jquery-animate-css-rotate-scale.js"></script>
    <script type="text/javascript" src="${path}/js/script.js"></script>
</head>
<body >
<div id="indicator"></div>
<div class="wrapper">
    <div class="sky init">
        <div id="clouds" class="clouds init"> </div>
    </div>

    <div class="convas init">
        <div id="mountain" class="mountain"></div>
        <div class="ground"></div>
        <div class="holder">
            <div class="rocks"></div>
            <div class="work-sign"></div>
            <div class="text-sign">
                <div class="text font">

                    We're Working Hard...

                </div>
            </div>
            <div class="init hole">
                <div class="sweat"></div>
                <div class="worker swing "></div>
                <div class="ground-bottom">
                    <div class="cleaner"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

