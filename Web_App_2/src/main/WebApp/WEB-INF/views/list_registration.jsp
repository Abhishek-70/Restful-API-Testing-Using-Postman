<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration Details</title>
</head>
<body>
	<table border=1>
		<tr>
		
			<th>student</th>
			<th>school</th>
			<th>email_id</th>
			<th>contact</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	 	<c:forEach var="app" items="${registration}">
			<tr>				
				<td>${app.name}</td>
				<td>${app.school}</td>
				<td>${app.email}</td>
				<td>${app.phone}</td>
				<td><a href="deleteById?s_NO_=${app.s_NO_}">Delete</a></td>
				<td><a href="getAndUpdateById?s_NO_=${app.s_NO_}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>