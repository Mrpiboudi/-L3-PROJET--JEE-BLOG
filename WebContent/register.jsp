<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp">
	<title>Entrez un compte</title></head>
<body>

	<form action="" method="POST">

		<div>
			entrer un pseudo : <input type='text' name='login'>
		</div>
		<br>
		<div>
			entrer votre addresse email : <input type='text' name='password'>
		</div>
		<br>
		<div>
			confirmer votre addresse email : <input type='text' name='password'>
		</div>
		<br>
		<div>
			entrer un mot de passe : <input type='text' name='password'>
		</div>
		<br>
		<div>
			confirmer un mot de passe : <input type='text' name='password'>
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