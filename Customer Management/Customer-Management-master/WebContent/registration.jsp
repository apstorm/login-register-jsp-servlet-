<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
<form action="regCustomer" method="post">
	<h1>Customer Registration Page</h1>
	
	<label for="tbName">Name:</label>
	<input type="text" name="tbName" id="tbName" /><br>
	
	<label for="tbEmail">Email:</label>
	<input type="email" name="tbEmail" id="tbEmail" /><br>
	
	<label for="tbMobile">Mobile:</label>
	<input type="tel" name="tbMobile" id="tbMobile"/><br>
	
	<label for="tbPass">Password:</label>
	<input type="password" name="tbPass" id="tbPass" /><br>
	
	<label >State:</label>
	<select name="ddlStates">
	<option value="">--Select--</option>
	<option value="Karnataka">KA</option>
	<option value="Tamil NAdu">TN</option>
	<option value="Andhra Pradesh">AP</option>
	<option value="Kerala">KL</option>
	</select>
	<br>
	
	<input type="submit" value="Register"/>
</form>

</body>
</html>