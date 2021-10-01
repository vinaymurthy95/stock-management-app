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
		<h1>Search successful</h1>
		<c:forEach var="pdto" items="${lispdto  }">
			<tr>
				<td><c:out value="${pdto.getId() }"></c:out></td>
				<td><c:out value="${pdto.getName() }"></c:out></td>
				<td><c:out value="${pdto.getCategory() }"></c:out></td>
				<td><c:out value="${pdto.getCompany() }"></c:out></td>
				<td><c:out value="${pdto.getPrice() }"></c:out></td>
			</tr>
		</c:forEach>
</body>
</html>