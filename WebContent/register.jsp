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
<title>Register</title>
</head>
<body>
	<br>
	<br>
	<div class="page">
		<a href="<%=request.getContextPath()%>/login"><b>Our Blog</b></a> <br>
		<br>
		<br>
		<form action="" method="POST">

			<h1>entrer un pseudo :</h1>
			<input type='text' name='login'> <br>
			<h1>entrer votre addresse email :</h1>
			<input type='text' name='email'> <br>
			<h1>confirmer votre addresse email :</h1>
			<input type='text' name='confirmeEmail'> <br>
			<h1>entrer un mot de passe :</h1>
			<input type='password' name='password'> <br>
			<h1>confirmer un mot de passe :</h1>
			<input type='password' name='confirmePassword'> <br>
			<div>
				<input type='submit' name='submit' value='register'>
			</div>
		</form>

		<div>
			<a href="<%=request.getContextPath()%>/login">vous avez déja un
				compte ?</a>
		</div>
	</div>
</body>
</html>
