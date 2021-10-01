<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Phone</td>
			<td>Address</td>
			<td>Company</td>
			<td>Price</td>
		</tr>
		<c:forEach var="dto" items="${pDtos  }">
			<tr>
				<td><c:out value="${dto.id }"></c:out></td>
				<td><c:out value="${dto.name }"></c:out></td>
				<td><c:out value="${dto.category }"></c:out></td>
				<td><c:out value="${dto.company }"></c:out></td>
				<td><c:out value="${dto.price }"></c:out></td>
				<%-- <td><a href="edit?id=${dto.id }">Edit</a></td>
				<td><a href="deleterecord?id=${dto.id }">Delete</a></td> --%>
			</tr>
		</c:forEach>

	</table>
</body>
</html>