<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/style.css">
<meta charset="ISO-8859-1">
<title>All Zoo's</title>
</head>
<body>
	<marquee>${requestScope.marqueeMessage}</marquee>
	<form method="post" action = "viewZoosNavServlet">
		<table>
			<tr>
				<th></th>
				<th><h1>Zoo</h1></th>
			</tr>
			<c:forEach items="${requestScope.allZoos}" var="currentZoo">
				<tr>
					<td><input type="radio" name="zoo_id" value="${currentZoo.getZoo_Id()}"></td>
					<td><h2>${currentZoo.zoo_name}</h2></td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "Change Name" name="whatDo">
		<input type = "submit" value = "Remove" name="whatDo">
		<input type="submit" value = "Add Zoo" name = "whatDo">
		<input type="submit" value = "Enter" name = "whatDo">
		<input type="submit" value = "Add Caretaker" name = "whatDo">
	</form>
</body>
</html>