<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Indain Railway Passenger Reservation</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="checkURL"method="POST">	
<h1>Passenger Current Status Enquiry</h1>
<p1>Enter the PNR for your booking below to get the current status. You will 
find it on the top left corner of the ticket.</p1><br></br>
<table>
<tr>
<th>Enter PNR No      	 </th><td> <input type="text"name="pnr"placeholder="Enter PNR Number"><br></br></td>


</tr>
 	
</table>
<div class="button">
<input type="submit"value="Submit">
<input type="reset"value="Cancel">
</div>
</form>
<form action="EmployeeURL"method="post">
<input type="submit"value="Show Employee Details">
</form>
</body>
</html>