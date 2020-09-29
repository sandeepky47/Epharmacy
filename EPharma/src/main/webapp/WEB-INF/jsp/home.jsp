<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Home</title>	

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
body{
background-image: url("https://media.gettyimages.com/photos/shadow-men-in-the-desert-picture-id939894910?s=2048x2048");
 }

#add{
font-size:20px;
 background:green;
 font-weight:bold;
 color:white;
}
#getexp{
font-size:20px;
 background:goldenrod;
 font-weight:bold;
 color:white;
}
#getall{
font-size:20px;
 background:blue;
 font-weight:bold;
 color:white;
}

#welhead{
padding-left:400px;
 font-weight:bold;
 color:red;
  font-family: "Times New Roman";
}
.temp{
 padding-left:100px; 
  padding-top:60px; 
}
.lab{
font-size:25px;
 font-weight:bold;
}
#error{
color:red;
font-weight:bold;
padding-left:420px;
}
#quote{
color:darkblue;
font-family: "Lucida Console";
padding-left:400px;
}.header{
background-color:#FFFFE0;
}
</style>
</head>
<body>
<header class="header" >
		<nav class="navbar navbar-style">
			<div class="container">
				<div class="navbar-header">
					<h2 id="welhead" >Welcome to MediWorks</h2>
					<h4 id="quote" >A Medical Shop Management Application</h4>
				</div>
           </div>
       </nav>
		</header>
 <div class="temp">
 <form action="getbyid" method="post" class="form-inline" >
 
        <div class="form-group mx-sm-3 mb-2" >
 		<label for="customer"  class="lab">Medicine ID</label>
   		 <input type="number" id="medicineid" name="medicineid" placeholder=" Enter Id" class="form-control"> 
   		 	 <button type="submit" class="btn btn-primary" >Search</button> <h4 id="error">${message }</h4> <h4 id="error">${formaterror}</h4>
   		 </div>   
   
  </form>
  <br>
   <p id="para1"><a id="add" href="/getaddpage">Add Medicine</a></p>
<p id="para2"><a id="getexp" href="/getexpired">Get Expired Medicines</a></p>
<p id="para2"><a id="getall" href="/getall">Get All Medicines</a></p>

</div>
	
</body>
</html>