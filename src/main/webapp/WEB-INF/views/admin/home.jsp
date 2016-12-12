<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

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
			        	<li class="active"><a href="/admin/home">Home</a></li>
			        	<li><a href="#">Users</a></li>
			      	</ul>
		    	</div>
		    </div>
		</nav>
	</jsp:body>
</t:page>