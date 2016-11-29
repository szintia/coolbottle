<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<t:page>
	<jsp:body>
		<div class="container">
			<h2>Registration</h2>
			<f:form  class="form-horizontal" method="post" modelAttribute="customer" action="/cbottle/registerCustomer">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-3">
						<label for="email">Email</label>
			  			<input type="text" class="form-control" name="email" placeholder="Enter email" />
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="password">Password</label>
			  			<input type="password" class="form-control" name="password" placeholder="Enter password" />
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="customer_name">Name</label>
			  			<input type="text" class="form-control" name="name" placeholder="Enter name" />
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="mobile">Phone Number</label>
			  			<input type="text" class="form-control" name="mobileNumber" placeholder="Enter phone number" />
		  			</div>
		  		</div>
		  		<%--remove if no longer necessary --%>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="balance">Balance</label>
			  			<input type="text" class="form-control" name="accountBalance" placeholder="" />
		  			</div>
		  		</div>
		  		<%--remove if no longer necessary --%>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-3">
			  			<label for="loyalty">Loyalty</label>
			  			<input type="text" class="form-control" name="loyalty" placeholder="" />
		  			</div>
		  		</div>
		  		<div class="form-group">        
      				<div class="col-sm-offset-2 col-sm-3">
        				<button type="submit" class="btn btn-default">Submit</button>
      				</div>
		  		</div>
			</f:form>
		</div>
	</jsp:body>
</t:page>