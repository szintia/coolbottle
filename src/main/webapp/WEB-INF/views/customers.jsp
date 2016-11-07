<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head></head>
<header></header>
<body>
	<div id="container">
		<h1>Cool Bottle - Customers</h1>
		<table id="listItem">
			<thead>
				<tr>
					<th class="header">E-mail</th>
					<th class="header">Password</th>
					<th class="header">Name</th>
					<th class="header">Mobile</th>
					<th class="header">Balance</th>
					<th class="header">Loyalty</th>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<tr class="row-container">
						<td class="data-row"><c:out value="${customer.email}" /></td>
						<td class="data-row"><c:out value="${customer.password}" /></td>
						<td class="data-row"><c:out value="${customer.name}" /></td>
						<td class="data-row"><c:out value="${customer.mobileNumber}" /></td>
						<td class="data-row"><c:out value="${customer.accountBalance}" /></td>
						<td class="data-row"><c:out value="${customer.loyalty}" /></td>
					</tr>
				</c:forEach>
			</thead>
		</table>
	</div>
</body>
</html>
