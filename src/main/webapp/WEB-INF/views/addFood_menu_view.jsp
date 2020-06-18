<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" />
		<title><spring:message text='My Cafe'/></title>
	</head>
<body>

<spring:url value="/home" var="home" htmlEscape="true"/>
<spring:url var="addFoodURL" value="/adminAddFood"/>
<spring:url var="addCategoryURL" value="/addCategory"/>

<c:set var="buttonName">
	<spring:message text='Ürün Ekle'/>
</c:set>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message text="Tüm Ürünler"/></h1>
			</div>										
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<legend><spring:message text="Yeni Ürün Ekle"/>
					<span style="float:right">
								<a href="${home}">
									<img src="<c:url value="/resources/images/icon_home.png" />" />
								</a>
							</span>
				</legend>
					<div class="row">
						<div class="col-md-12">
							<form:form modelAttribute="foodToBeAdded" class="form-horizontal" method="post" action="${addFoodURL}">
								<fieldset>
									<div class="form-group">
										<label class="control-label col-lg-2" for="name">
											<spring:message text="Ürün Adı"/>
										</label>
										<div class="col-lg-10">
											<form:input id="name" path="name" type="text" class="form:input-large"/>
											<form:errors path="name" cssClass="text-danger"/>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-lg-2" for="price">
											<spring:message text="Fiyat"/>
										</label>
										<div class="col-lg-10">
											<div class="form:input-prepend">
												<form:input id="price" path="price" type="int" class="form:input-large"/>
												<form:errors path="price" cssClass="text-danger" cssStyle="display: inline-flex;"/>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-lg-2" for="description">
											<spring:message text="Açıklama"/>
										</label>
										<div class="col-lg-10">
											<form:textarea id="description" path="description" rows = "2"/>
										</div>
									</div>


									<div class="form-group">
										<label class="control-label col-lg-2" for="type">
											<spring:message text="Categori"/>
										</label>
										<div class="col-lg-10">
											<form:select id="type" path="type" type="text" class="form:input-large" items="${foodCategories}"/>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<input type="submit" id="btnAdd" class="btn btn-primary" value ="${buttonName}"/>
										</div>
									</div>
								</fieldset>
							</form:form>
						</div>
						<legend><spring:message text="Yeni Kategori Ekle"/></legend>
						<div class="col-md-12">
							<form:form modelAttribute="categoryToBeAdded" class="form-horizontal" method="post" action="${addCategoryURL}">
								<fieldset>
									<div class="form-group">
										<label class="control-label col-lg-2" for="categoryName">
											<spring:message text="Kategori Adı"/>
										</label>
										<div class="col-lg-10">
											<form:input id="categoryName" path="categoryName" type="text" class="form:input-large"/>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<input type="submit" id="btnCtg" class="btn btn-primary" value ="Categori Ekle"/>
										</div>
									</div>
								</fieldset>
							</form:form>
						</div>
					</div>
		     </div>
	    </div>
		<div class="row">
			<div class="col-md-12">
				<legend><spring:message text="Ürünler"/></legend>
				<div class="table-responsive">
					<table id="example" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><spring:message text="ID"/></th>
								<th><spring:message text="Ürün Adı"/></th>
								<th><spring:message text="Açıklama"/></th>
								<th><spring:message text="Fiyatı"/></th>
								<th><spring:message text="Categori"/></th>
							</tr>
						</thead>
						<tbody>
					
							<c:forEach items="${foods}" var="foods">
								<tr>
									<td><c:out value="${foods.id}" /></td>
									<td><c:out value="${foods.name}" /></td>
									<td><c:out value="${foods.description}" /></td>
									<td><fmt:formatNumber pattern="#0.00" value="${foods.price}"/></td>
									<td><c:out value="${foods.type}" /></td>
									<td colspan="2">
										<a href="food.delete/${foods.id}"
											class="btn btn-danger" type="button">
											<spring:message text="Sil"/>
										</a>
									</td>									    
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>					
	</section>
</body>
</html>
