<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<%@ page isELIgnored ="false" %>

<t:page>
	<jsp:body>
		<div class="container">
			<h1>Sign in</h1>
			<c:if test="${not empty error}">
				<div class="error">${error} blabla</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
			<c:url var="loginUrl" value="/j_spring_security_check"/>
			<f:form  class="form-horizontal" action="${loginUrl}" method="post" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<label for="email">Email</label>
			  			<input type="text" class="form-control" name="email" placeholder="Enter email" required autofocus/>
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="password">Password</label>
			  			<input type="password" class="form-control" name="password" placeholder="Enter password" required/>
		  			</div>
		  		</div>
		  		<div class="form-group">
			  		<label class="col-sm-offset-2 col-sm-2">
	                    <input type="checkbox" value="remember-me">
	                    Remember me
	                </label>
	                <label class="need-help">
						<a href="#">Need help? </a>
					</label>
				</div>
				<div class="form-group">        
      				<div class="col-sm-offset-2 col-sm-3">
        				<button type="submit" class="btn btn-default">Sign in</button>
      				</div>
		  		</div>
		  		<div class="col-sm-offset-2">
					<a href="/cbottle/registrationForm">Create an account </a>
				</div>
			</f:form>
		</div>
	</jsp:body>
</t:page>