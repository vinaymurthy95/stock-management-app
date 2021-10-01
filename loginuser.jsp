<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login here</h1>

	<h4 style="color: red">${msg }</h4>
	<form action="userlogin" method="post">
		<input type="text" name="userName" placeholder="enter username"><br>
		<input type="password" name="password" placeholder="enter password"><br>
		<input type="submit" value="Login">
</body>
</html>