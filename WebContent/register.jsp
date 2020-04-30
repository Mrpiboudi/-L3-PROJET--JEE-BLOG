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
		<br> <br>
		<form action="" method="POST">

			<div>
				<label for="pseudo" /> <input type="text" id="login" name="login"
					placeholder="pseudo">
			</div>
			<br>
			<div>
				<select name="sexe" size="1" id="sexe">
					<option><div class="description">Feminin</div>
					<option><div class="description">Masculin</div>
				</select>
			</div>
			<br>
			<div>
				<label for="nom" /> <input type="text" id="lastname" name="lastname"
					placeholder="nom"><br>
			</div>
			<br>
			<div>
				<label for="prenom" /> <input type="text" id="firstname"
					name="firstname" placeholder="prenom"><br>
			</div>
			<div>
				<label for="age" /> <input type=text id="age" name="age"
					placeholder="age"><br>
			</div>
			<div>
				<label for="mdp" /> <input type="password" id="password"
					name="password" placeholder=" mot de passe">
			</div>
			<br>
			<div>
				<label for="mdp_confirm" /> <input type="password"
					id="confirmePassword" name="confirmePassword"
					placeholder="confirmer mot de passe">
			</div>
			<br>
			<div>
				<label for="email" /> <input type="email" id="email" name="email"
					placeholder="email address"><br>
			</div>
			<br>
			<div>
				<label for="email" /> <input type="email" id="confirmeEmail"
					name="confirmeEmail" placeholder="confirm email address"><br>
			</div>
			<br>
			<div>
				<input type='submit' name='submit' value='register'>
			</div>
		</form>

		<div>
			<a href="<%=request.getContextPath()%>/LoginServlet">vous avez
				déja un compte ?</a>
		</div>
	</div>
</body>
</html>
