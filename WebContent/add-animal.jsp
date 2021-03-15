<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A New Animal</title>
</head>
<body>
	<form method = "post" action = "addServlet">
		<input type = "hidden" name = "caretaker_id" value = "${requestScope.care_id}">
		Name: <input type ="text" name = "name" ><br>
		Age: <input type = "text" name = "age"><br>
		
		<input type ="submit" name = "whatDo" value = "Add Animal">
	</form>

</body>
</html>