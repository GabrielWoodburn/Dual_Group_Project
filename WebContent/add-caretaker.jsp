<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Caretaker</title>
</head>
<body>
	<marquee></marquee>
	<form method = "post" action = "addServlet">
		First Name: <input type ="text" name = "first_name">
		Last Name: <input type = "text" name = "last_name"><br><br>
		Hire Date:
		<input type ="text" name = "month" placeholder="mm" size="4"> 
		<input type ="text" name = "day" placeholder="dd" size="4">
		<input type ="text" name = "year" placeholder="yyyy"><br>
		<input type = "hidden" name = "zoo_id" value="${requestScope.zoo_id}">
		<input type = "submit" name = "whatDo" value = "Add New Caretaker">
	</form>

</body>
</html>