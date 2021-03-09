<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
<form method = "post" action = "navigationServlet" >
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.zoo}</td>
	<td>${currentitem.animal}</td>
	</tr>
</c:forEach>
</table>
<br />
<input type ="submit" value ="edit" name="doThisToItem" class="btn btn-warning">
<input type ="submit" value ="delete" name="doThisToItem" class="btn btn-danger">
<input type="submit" value ="add" name ="doThisToItem" class="btn btn-success">
</form>
</body>
</html>