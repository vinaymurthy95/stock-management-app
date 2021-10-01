<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert page</title>
</head>
<body>
	<h1 align="left">Product Insertion</h1>
	<hr>
	<h3 align="left">
		<form action="insertproduct" method="post">
			<input type="text" name="name" placeholder="Name"> <br>
			<input type="text" name="category" placeholder="Category"> <br>
			<input type="text" name="company" placeholder="Company"> <br>
			<input type="number" name="quantity" placeholder="quantity">
			<br> <input type="number" name="price" placeholder="Price">
			<br> <input type="submit" name="Registration">
		</form>
	</h3>
</body>
</html>