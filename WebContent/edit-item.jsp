<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
<form action="editItemServlet" method="post">
Store: <input type="text" name="zoo" value="${itemToEdit.zoo}">
Item: <input type="text" name="animal" value="${itemToEdit.animal}">
<input type ="hidden" name="id" value="${itemToEdit.id}">
<input type ="submit" value="Save Edited Item"> 
</form>
</body>
</html>