<nav class="navbar navbar-inverse">
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
						<li><a class="home"> <span>Hello <c:out value="${name}" />!</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a class="home" href="/cbottle/login"><span>Login</span></a></li>
					</c:otherwise>
				</c:choose>
		        <li><a href="/cbottle/home">Home</a></li>
		        <li><a href="/cbottle/bottles">Bottle</a></li>
		        <li><a href="/cbottle/about">About us</a></li>
		        <li><a href="/cbottle/contact">Contact</a></li>
	  		</ul>
	        <ul class="nav navbar-nav navbar-right">
		        <li><a href="/cbottle/registrationForm"><span class="glyphicon glyphicon-user"></span> Register</a></li>
		        <li><a href="/cbottle/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      	</ul>
		</div>
	</div>
</nav>