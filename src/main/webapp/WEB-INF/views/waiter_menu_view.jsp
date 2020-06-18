<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<spring:url value="/home" var="home" htmlEscape="true"/>
<spring:url value="/takeOrder" var="takeOrder"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<title>SİPARİŞLER</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>SİPARİŞİ AL</h1>
			</div>										
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				
				<span style="float:right">
					<a href="${home}">
						<img src="<c:url value="/resources/images/icon_home.png" />" />
					</a>						
				</span>
			
				<legend><spring:message text="Verilen Siparişler"/></legend>

				<table id="example" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Sipariş NO</th>
							<th>Masa NO</th>
							<th>Müşteri Adı</th>
							<th>Ürünler</th>
							<th>Sipariş Notu</th>
							<th>Garson Adı</th>
							<th>Teslim Et</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${placedOrders}" var="order">
							<tr>
								<td><c:out value="${order.id}" /></td>
								<td><c:out value="${order.tableNo}" /></td>
								<td><c:out value="${order.customer.customerName}"/></td>
								<td>
									<c:forEach items="${order.foodOrders}" var="foodOrder">
										<c:forEach items="${foodOrder.foods}" var="food">
											<table>
												<tr><c:out value="${food.name}"/></tr>
											</table>
										</c:forEach>
									</c:forEach>
								</td>
								<td><c:out value="${order.orderDescription}"/></td>
								<td><c:out value="${order.waiterNameTookTheOrder}"/></td>
								<td>
									<a href="order.delete/${order.id}"class="btn btn-danger" type="button">
										<spring:message text="Siparişi Teslim Et"/>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<legend><spring:message text="Teslim Edilen Siparişler"/></legend>

				<table class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>Sipariş NO</th>
						<th>Masa NO</th>
						<th>Müşteri Adı</th>
						<th>Ürünler</th>
						<th>Sipariş Notu</th>
						<th>Garson Adı</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${deliveredOrders}" var="deliveredOrders">
						<tr>
							<td><c:out value="${deliveredOrders.id}" /></td>
							<td><c:out value="${deliveredOrders.tableNo}" /></td>
							<td><c:out value="${deliveredOrders.customer.customerName}"/></td>
							<td>
								<c:forEach items="${deliveredOrders.foodOrders}" var="foodOrder">
									<c:forEach items="${foodOrder.foods}" var="food">
										<table>
											<tr><c:out value="${food.name}"/></tr>
										</table>
									</c:forEach>
								</c:forEach>
							</td>
							<td><c:out value="${deliveredOrders.orderDescription}"/></td>
							<td><c:out value="${deliveredOrders.waiterNameTookTheOrder}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
</html>
