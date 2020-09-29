<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Get Medicine By id</title>	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
body{
background-color: #dcdcdc45; 
}
#custheader{
color:blue;
}
.tableclass{
padding:60px;
}

#home{
font-size:20px;
 background:brown;
 font-weight:bold;
 color:white;
}

</style>
</head>
<body>

		

 <div class="tableclass">
  <h2 id="custheader" >Medicine:</h2>
 <table  class="table table-bordered">
 <thead class="thead-dark">
  <tr>
  <th scope="col">Medicine Id</th>
    <th scope="col">Medicine Name</th> 
     <th scope="col">Company</th>
    <th scope="col">Manufacture Date</th>
     <th scope="col">Expire Date</th>
      <th scope="col">Price</th>
    
  </tr>
  </thead>
  <tbody>
              
                <tr>
                   <td>${medicine.medicineId}</td>
                    <td>${medicine.medicineName}</td>
                     <td>${medicine.company}</td>
                  <td><fmt:formatDate  value="${medicine.manufactureDate}" pattern="dd-MM-yyyy"/></td>   
                     <td><fmt:formatDate  value="${medicine.expireDate}" pattern="dd-MM-yyyy"/></td>   
                        <td>${medicine.amount}</td>     
                </tr>  
     </tbody>
 
</table>
<a id="home" href="/" >Home</a>
</div>

	
</body>
</html>