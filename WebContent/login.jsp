<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<div class="logo">
		<a href="<%=request.getContextPath()%>/login"><b>Our</b>Blog</a>
	</div>

	<form action="" method="POST">

		<div>
			login : <input type='text' name='login'>
		</div>
		<br>
		<div>
			password <input type='text' name='password'>
		</div>
		<br>
		<div>
			<input type='submit' name='submit' value='connexion'>
		</div>
	</form>

	<div>
		<a href="<%=request.getContextPath()%>/login">Or Register a new
			account</a>
	</div>
</body>
</html>