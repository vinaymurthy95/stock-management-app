<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Search By Products</h1>
	<h3 align="center">
		<form action="searchproduct" method="post">
			<label for="Products">Select type:</label> <br> <select
				name="type" id="Products">
				<option value="Select_By_Name">Select By Name</option>
				<option value="Select_By_Category">Select By Category</option>
				<option value="Select_By_Company">Select By Company</option>
			</select> <br> <input type="text" name="key" placeholder="Key"><br>
			<input type="submit" value="submit">
		</form>
	</h3>
</body>
</html>