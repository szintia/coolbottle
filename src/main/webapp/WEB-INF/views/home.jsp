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
		      	<c:choose>
				<c:when test="${not empty name}">
					<li><a class="home"> <span>Hello <c:out value="${name}" />!
						</span></a></li>
				</c:when>
				<c:otherwise>
					<li><a class="home" href="/cbottle/login"> <span>Login</span>
					</a></li>
				</c:otherwise>
				</c:choose>
		        <li class="active"><a href="/cbottle/home">Home</a></li>
		        <li><a href="#">Page 2</a></li>
		        <li><a href="#">Page 3</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="/cbottle/registrationForm"><span class="glyphicon glyphicon-user"></span> Register</a></li>
		        <li><a href="/cbottle/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
	  
		<div class="container">
		</div>
	</jsp:body>
</t:page>