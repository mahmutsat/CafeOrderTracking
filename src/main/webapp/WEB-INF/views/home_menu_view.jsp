<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:url value="/menu" var="mainMenuURL" htmlEscape="true"/>
<spring:url value="/foodAddCart" var="addToCart" htmlEscape="true"/>
<spring:url value="/admin" var="adminMenu" htmlEscape="true"/>
<spring:url value="/cart" var="cart" htmlEscape="true"/>
<spring:url value="/login" var="changeCustomer" htmlEscape="true"/>
<spring:url value="/kitchen" var="kitchen" htmlEscape="true"/>
<spring:url value="/waiter" var="waiter" htmlEscape="true"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

    <title><spring:message text="My Cafe"/></title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message text="My Cafe"/></h1>
            <p><spring:message text="En İyi Cafe"/></p>
            <p> Hoşgeldiniz ${customerName}</p>
            <p>
                <a href="${changeCustomer}"> Kullanıcı Değiştir </a>
            </p>
        </div>
    </div>
</section>

<div id="page-content-wrapper">
    <section class="container">
        <div class="row">
            <div class="col-md-6"></div>
            <div class="col-md-6" style="alignment: right; padding-bottom: 20px">
				<span style="float:right">
				<a href="${adminMenu}" style="padding-right: 10px">Admin
					<img src="<c:url value="/resources/images/admin.png"/>"/>
				</a>
                |
                <a href="${kitchen}" style="padding-right: 10px">Mutfak
					<img src="<c:url value="/resources/images/kitchen_icon.png" />"/>
				</a>
                |
                <a href="${waiter}" style="padding-right: 10px">Siparişler
					<img src="<c:url value="/resources/images/waiter-icon.png" />"/>
				</a>
                |
				<a href="${cart}" style="padding-right: 10px">Sepet
					<img src="<c:url value="/resources/images/order_icon.png" />"/>
				</a>
				</span>
            </div>
        </div>
        <c:forEach items="${foods}" var="foodsMap">
            <div class="col">
                <div class="col-md-12">
                    <div class="col-md-3" style="background-color: #1b6d85; padding-top: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h1>${foodsMap.key}</h1>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${foodsMap.value}" var="foods">
                        <div class="col-md-3" style="padding-bottom: 15px">
                            <div class="thumbnail">
                                <div class="caption">
                                    <h3>${foods.name}</h3>
                                    <p>${starters.description}</p>
                                    <p><fmt:formatNumber pattern="#0.00" value="${foods.price}"/> TL</p>
                                    <p>
                                        <a href="${addToCart}/${foods.id}" class="btn btn-primary">
                                            <span class="glyphicon-info-sign glyphicon" /></span>
                                            <spring:message text="Sepete Ekle"/>
                                        </a>
                                    </p>

                                </div>
                            </div>
                         </div>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </section>
</div>
</div>
</body>
</html>
