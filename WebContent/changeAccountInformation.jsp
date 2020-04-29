<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp">
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style/style.css">
	<link rel="stylesheet" href="style/global.css">
<title>Vos informations</title>
</head>
<body>
<div class="page">
	<form action="" method="POST">

		<h1>modifier votre addresse email</h1>
		 <input type='text' name='email'>
		<br>

			<h1>modifier votre age</h1>
			 <input type='text' name='age'>
		<br>
		<h1>votre sexe </h1>
		<input type='text' name='sexe'>
		<br>
		<h1>ajouter une photo de profil ? </h1>
		<input type='text' name='picture'>
		<br>
		<br>
			<input type='submit' name='submit'value='modifier les informations !'>
	</form>


	<form action="" method="POST">
		<input type='danger' name='submit' value='supprimer votre compte ?'  >
	</form>
</div>
</body>
</html>
