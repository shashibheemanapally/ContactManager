<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager</title>
</head>
<body>
	<div align="center">
		<h1>Contacts</h1>
		<h3 ><a href="new">Add new contact</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Options</th>
			</tr>
			
			<c:forEach items="${listContact }" var="contact" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contact.name }</td>
					<td>${contact.email }</td>
					<td>${contact.address }</td>
					<td>${contact.phone }</td>
					<td>
						<a href="edit?c_id=${contact.c_id}">Edit</a>
						&nbsp;&nbsp;
						<a href="delete?c_id=${contact.c_id}">Delete</a>
					</td>
					
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>
