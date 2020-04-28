<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./css/login.css"
	media="all">
<link type="text/css" rel="stylesheet" href="./css/style.css"
	media="all">

<title>login</title>
</head>
<body>



	<br>
	<br>
	<div class="page">
		<a href="<%=request.getContextPath()%>/login"><b>Our Blog</b></a> <br>
		<br>
		<br>
		<form action="" method="POST">

			<h1>login</h1>
			<input type='text' name='login'> <br>
			<h1>password</h1>
			<input type='password' name='password'> <br> <br>
			<div>
				<input type='submit' name='submit' value='connexion'>
			</div>
		</form>

		<div>
			<a href="<%=request.getContextPath()%>/register">Or Register a
				new account</a>
		</div>
	</div>
</body>
</html>
