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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
* {
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color: #E4E9F7;
}

/* style the container */
.container {
	
	
	right: 530px;
	width: 400px;
	border: 3px solid #73AD21;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px 20px 60px 60px;
}

/* style the submit button */
input[type=submit] {
	background-color: #04AA6D;
	color: white;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.col {
	width: 100%;
	margin-top: 0;
}

/* show the hidden text on small screens */
.hide-md-lg {
	display: block;
	text-align: center;
}

/* Style the content */
.content {
	padding: 10px;
	height: 700px;
}

/* Style the footer */
.footer {
	background-color: #333;
	padding: 20px;
}
</style>

</head>
<body>

	
	<!-- Login Form -->
	<div class="content">
		<h1>LOGIN</h1>
		<p>Explore with Telnet.....</p>
		<div class="container">


			<div class="col">
				
					<p>Sign in manually</p>
				
				<form action="UserLogin" method="post" class="col-lg-6 offset-lg-3 ">
					<div class="row justify-content-center">
						User Name <input type="text" name="userName"
							placeholder="user Name"><br> <br> password <input
							type="password" name="password" placeholder="password"> <br>
						<br> <input type="submit" name="submit" value="login">
					</div>
				</form>
			</div>

		</div>
	</div>
	
	
	<div class="footer">
		<p>Footer</p>
	</div>
</body>
</html>