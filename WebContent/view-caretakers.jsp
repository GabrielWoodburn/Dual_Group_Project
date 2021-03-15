<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Caretakers</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<marquee>Viewing All Caretakers For ${requestScope.zoo.getZoo_name()}</marquee>
	<form method="post" action = "viewCaretakerNavServlet">
		<input type = "hidden" name ="zoo_id" value = "${zoo.getZoo_Id()}">
		<table>
			<tr>
				<th></th>
				<th><h4>First Name</h4></th>
				<th><h4>Last Name</h4></th>
				<th><h4>Date Hired</h4></th>
				<th><h4>Animals</h4></th>
			</tr>
			<c:forEach items="${requestScope.zoo.getCaretakerList()}" var="currentCaretaker">
				<tr>
					<td><input type="radio" name="caretaker_id" value="${currentCaretaker.getCaretaker_Id()}"></td>
					<td><h2>${currentCaretaker.getCaretaker_First()}</h2></td>
					<td><h2>${currentCaretaker.getCaretaker_Last()}</h2></td>
					<td><h2>${currentCaretaker.getHireDate()}</h2></td>
					
					<td>
						<ul>
							<c:forEach items = "${currentCaretaker.getAnimalList()}" var = "currentAnimal">
								<li>${currentAnimal.getAnimal_Name()}</li>
							</c:forEach>
						</ul>					
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "Add New Caretaker" name="whatDo">
		<input type = "submit" value = "Remove" name="whatDo">
		<input type="submit" value = "Assign New Animal" name = "whatDo">
	</form>
</body>
</html>