<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp" %>
	<div class="container">
		<h2>Bottles</h2>
		<c:if test="${not empty bottles}">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Product ID</td>
						<td>Category ID</td>
						<td>Product Name</td>
						<td>Description</td>
						<td>Price</td>
						<td>Amount</td>
					</tr>
				</thead>
				<c:forEach var="bottle" items="${bottles}">
					<tr>
						<td>${bottle.productId}</td>
						<td>${bottle.categoryId}</td>
						<td>${bottle.productName}</td>
						<td>${bottle.description}</td>
						<td>${bottle.price}</td>
						<td>${bottle.amount}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>