<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Addition</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
body {
    background-image: url("https://media.gettyimages.com/photos/shadow-men-in-the-desert-picture-id939894910?s=2048x2048");
	
}

.container {
 padding-left: 500px;
	margin: 10px;
}

.formStyle {
	background-color: #90EE90;
	box-shadow: 4px 7px 14px limegreen;
	padding: 20px;
}

#submit:hover {
	color: blue;
	background-color: white;
	font-weight: bold;
}

#error{
color:red;
}
#head{
font-weight:bold;color:darkblue;
}
</style>
</head>
<body>
	
	
	<div class="container">
	<h2  id="head" >Add Medicine</h2>
		<div class="row">
			<div class="col-lg-6 formStyle">
				<form:form action="adding" method="post" modelAttribute="medicine">
					<div class="form-group">
						<form:label path="medicineName">Medicine Name</form:label>
						<form:input path="medicineName" class="form-control" />
						<form:errors path="medicineName" id="error"/>
					</div>
						<div class="form-group">
						<form:label path="company">Company</form:label>
						<form:select class="form-control" path="company">
						<form:option value="">Select</form:option>
						<form:options items="${companies}"/>
						</form:select>
						<form:errors path="company" id="error" />
					</div>
					
					<div class="form-group">
						<form:label path="manufactureDate">Manufacture Date</form:label>
						<form:input path="manufactureDate" type="date" class="form-control" />
						<form:errors path="manufactureDate" id="error" />
					</div>
					<div class="form-group">
						<form:label path="expireDate">Expire Date</form:label>
						<form:input path="expireDate" type="date" class="form-control" />
						<form:errors path="expireDate" id="error" />
							   <p id="error">${dateerror}</p>
					</div>
					
					<div class="form-group">
						<form:label path="amount">Amount</form:label>
						<form:input path="amount" class="form-control" />
						<form:errors path="amount" id="error" />
					</div>
					

                 <input type="submit" id="submit" value="save" class="btn btn-primary btn-block">
                 <a href="/" class="btn btn-primary btn-block" >Cancel</a>
                </form:form>
			</div>
		</div>
	</div>

</body>
</html>