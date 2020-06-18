<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="output" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/home" var="mainpage" htmlEscape="true"/>
<html>
<head>
    <title>Welcome</title>

    <script type="text/javascript" src='object.js'> </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Hoşgeldiniz</h1>
            <p style="color: #ac2925">Lütfen İsminizi Giriniz</p>
            <p>
            <form action="home/" >
                <input type="text" name="name">
                <div style="padding-top: 15px">
                    <input type="submit" value="Devam Et" class="btn btn-primary">
                </div>
            </form>
            </p>
        </div>
    </div>
</section>

<%--    <form action="home/" >--%>
<%--        <output style="padding-left: 15px">İsminizi Giriniz</output>--%>
<%--        İsminizi Giriniz :<input type="text" name="name">--%>
<%--        <input type="submit" value="Devam Et" class="btn btn-primary">--%>
<%--    </form>--%>

</body>
</html>
