<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">

body{
background-color: #dcdcdc45;
}
.container{
   padding-left:400px;
	margin: 10px;

}
#custheader{
color:blue;
}
.temp{
padding:40px;
}
#submit:hover {
	color: blue;
	background-color: white;
	font-weight: bold;
}
#error{
color:red;
}
</style>
</head>
<body>
	
	<div class="temp">
	<h1 id="custheader">Edit Medicine Details:</h1>
	<form:form action="editing" method="post" modelAttribute="medicine">
	<table class="table table-bordered ">
		<tr>
			<th>Medicine Name</th>
			<th>Company</th>
			<th>Manufacture Date</th>
			<th>Expire Date</th>
			<th>Price</th>

		</tr>
		<tr>
			<td><form:input  path="medicineName" value="${medicine.medicineName}"/>
			<form:errors path="medicineName" id="error"/></td>
			
			<td><form:select path="company" >
						<form:options  items="${companies}"/>
						</form:select>
						<form:errors path="company" id="error" /></td>
            <fmt:formatDate value="${medicine.manufactureDate}"  pattern="yyyy-MM-dd" var="date1"/>
			  <td><form:input path="manufactureDate" type="date" value="${date1}" /> 
			  <form:errors path="manufactureDate" id="error" /></td>
			  
			    <fmt:formatDate value="${medicine.manufactureDate}"  pattern="yyyy-MM-dd" var="date2"/>
			<td><form:input type="date"  path="expireDate" value="${date2}"/>
			<form:errors path="expireDate" id="error" /><p id="error">${dateerror}</p></td>
			
			<td><form:input type="number" path="amount" value="${medicine.amount}"/>
			<form:errors path="amount" id="error" /> </td>
		</tr>
		<tr><td><input type="submit" id="submit" value="save" class="btn btn-primary btn-block">
		 <input type="button" id="submit" value="Cancel" class="btn btn-primary btn-block" onclick="window.location.href='/'">
		</td></tr>
	</table>
	<form:input type="hidden" path="medicineId" value="${medicine.medicineId}"/>
	
	</form:form>
	</div>
</body>
</html>