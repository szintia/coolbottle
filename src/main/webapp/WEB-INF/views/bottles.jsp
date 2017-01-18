<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>


<t:page>
	<jsp:body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="/cbottle">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="#">Cool Bottle</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="/cbottle/home">Home</a></li>
		        <li><a href="#">Page 2</a></li>
		        <li><a href="cbottle/about">About</a></li>
		      </ul>
		      <div id="container">
				  <c:if test="${not empty bottles}">
					<c:forEach var="bottle" items="${bottles}">
						<tr>
							<td><c:out value="${bottle.productId}" /></td>
							<td><c:out value="${bottle.categoryId}" /></td>
							<td><c:out value="${bottle.productName}" /></td>
							<td><c:out value="${bottle.description}" /></td>
							<td><c:out value="${bottle.price}" /></td>
							<td><c:out value="${bottle.amount}" /></td>
							<td><c:out value="${bottle.date}" /></td>
						</tr>
					</c:forEach>
				  </c:if>
			  </div>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="/cbottle/registrationForm"><span class="glyphicon glyphicon-user"></span> Register</a></li>
		        <li><a href="/cbottle/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</jsp:body>
</t:page>