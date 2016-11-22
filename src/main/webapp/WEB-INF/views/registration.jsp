<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page>
	<jsp:body>
		<div class="container">
			<h2>Registration</h2>
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<label for="email">Email</label>
			  			<input type="text" class="form-control" id="email" placeholder="Enter email">
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="passw">Password</label>
			  			<input type="password" class="form-control" id="passw" placeholder="Enter password">
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="name">Name</label>
			  			<input type="text" class="form-control" id="name" placeholder="Enter name">
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="phone">Phone Number</label>
			  			<input type="text" class="form-control" id="phone" placeholder="Enter phone number">
		  			</div>
		  		</div>
		  		<div class="form-group">        
      				<div class="col-sm-offset-2 col-sm-3">
        				<button type="submit" class="btn btn-default">Submit</button>
      				</div>
		  		</div>
			</form>
		</div>
	</jsp:body>
</t:page>