<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<spring:url value="/order.list" var="orderListAll" htmlEscape="true"/>
<spring:url value="/order.list?groupBy=customerName" var="orderListAllGroupByName" htmlEscape="true"/> 
<spring:url value="/home" var="home" htmlEscape="true"/>
<spring:url value="/placedOrder" var="placedOrder" htmlEscape="true"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<title>Sepet</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Sepetiniz</h1>
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
			
				<legend><spring:message text="Ürünler"/></legend>
				<div class="table-responsive">
					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Müşteri Adı</th>
								<th>Ürünler</th>
								<th>Fiyatı</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allCustomerOrders}" var="orderMap" >
								<tr>
									<td><c:out value="${orderMap.key.customerName}" /></td>
									<td>
										<c:forEach items="${orderMap.value}" var="orders">
											<c:forEach items="${orders.foods}" var="food">
												<table>
													<tr><c:out value="${food.name}" /></tr>
												</table>
											</c:forEach>
										</c:forEach>
									</td>
									<td>
										<c:forEach items="${orderMap.value}" var="orders">
											<c:forEach items="${orders.foods}" var="food">
												<table>
													<tr><c:out value="${food.price}" /></tr>
												</table>
											</c:forEach>
										</c:forEach>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
						<tr>
							<td>Toplam Tutar</td>
							<td></td>
							<td><fmt:formatNumber pattern="#0.00" value="${ordersTotals}"/></td>
						</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered">
					<thead>
					<tr>
						<th>Sipariş Notu</th>
						<th>Masa Numarası</th>
						<th>Siarpişi Onayla</th>
					</tr>
					</thead>
					<form action="${placedOrder}/">
						<td><textarea name="orderDescription" cols="30" rows="2"></textarea> </td>
						<td><input name="tableNo" maxlength="10"></input> </td>
						<td><input type="submit" value="Siparişi Onayla" class="btn btn-primary"></td>
					</form>
				</table>
			</div>
		</div>
	</section>
</body>
</html>
