<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/logInForm.css" />
</head>
<body>
	<div class="logIn">
		<img src="../../images/user.ico" class="user" />
		<h2 id="h2">Log In Here</h2>
		<p>Username</p>
		<input type="text" name="username" id="username" placeholder="Enter Username" />
		<p>Password</p>
		<input type="password" name="password" id="password"
			placeholder="..........." />
		<p>Account Type</p>
		<select id="user_type">
			<option value="">Select Type</option>
			<option value="Student">Student</option>
			<option value="Faculty">Faculty</option>
			<option value="Admin">Admin</option>
		</select> <input type="submit" name="submit" onclick="submit()" value="Log In" />
	</div>
	<footer></footer>
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../../js/loginHome.js"></script>
</html>