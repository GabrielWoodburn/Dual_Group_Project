<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Caretaker</title>
</head>
<body>
	<form method="post" action = "viewCaretakerNavServlet"> 
		<input type = "hidden" name="caretaker_id" value = "${requestScope.caretaker.getCaretaker_Id()}">
		First Name: <input type ="text" name = "first_name" value = "${requestScope.caretaker.getCaretaker_First()}">
		Last Name: <input type = "text" name = "last_name" value = "${requestScope.caretaker.getCaretaker_Last()}"><br><br>
		Hire Date: <br>
		Month: <input type = "text" name = "month" placeholder ="mm" value = "${requestScope.caretaker.getHireDate().getMonthValue()}">
		Day: <input type = "text" name = "day" placeholder = "dd" value = "${requestScope.caretaker.getHireDate().getDayOfMonth()}">
		Year: <input type = "text" name = "year" placeholder = "yyyy" value = "${requestScope.caretaker.getHireDate().getYear()}">
		<br>
		<input type= "submit" name = "whatDo" value = "Update Caretaker">
		
	</form>

</body>
</html>