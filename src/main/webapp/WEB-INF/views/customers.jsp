<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:page>
	<jsp:body>
		<div class="container">
			<h2>Customers</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>E-mail</th>
						<th>Password</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Balance</th>
						<th>Loyalty</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td><c:out value="${customer.email}" /></td>
							<td><c:out value="${customer.password}" /></td>
							<td><c:out value="${customer.name}" /></td>
							<td><c:out value="${customer.mobileNumber}" /></td>
							<td><c:out value="${customer.accountBalance}" /></td>
							<td><c:out value="${customer.loyalty}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</t:page>