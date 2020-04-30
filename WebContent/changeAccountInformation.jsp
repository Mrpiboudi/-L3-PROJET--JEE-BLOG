<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp">
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style/style.css">
	<link rel="stylesheet" href="style/global.css">
	<title>Vos informations</title></head>
<body>
	
	<div id = "haut">
		<span><a href = "<%=request.getContextPath()%>/ProfileServlet">Retour</a></span>
		<h1>Modifications de vos informations</h1>
	</div>
	
	<div class="page">
		<form action="" method="POST">
		
			<label for="pseudo">Nouveau pseudo:</label> 
			<input type="text" id="pseudo" name = "pseudo">
			<span><em>Ancien pseudo : <c:out value = "${u.getPseudo()}"/></em></span>
			<br>
			
			<label for="nom">Nouveau nom:</label> 
			<input type="text" id="nom" name = "nom">
			<span><em>Ancien nom : <c:out value = "${u.getLastname()}"/></em></span>
			<br>
			
			<label for="prenom">Nouveau prenom:</label> 
			<input type="text" id="prenom" name = "prenom">
			<span><em>Ancien prenom : <c:out value = "${u.getFirstname()}"/></em></span>
			<br>
			
			<label for="age">Nouvel age:</label> 
			<input type=text id="age" name ="age">
			<span><em>Ancien age : <c:out value = "${u.getAge()}"/></em></span>
			<br>
			
			<label for="mdp">Nouveau mot de passe:</label> 
			<input type="password" id="mdp" name = "mdp">
			<label for="mdp_confirm">Confirmation nouveau mot de passe:</label> 
			<input type="password" id="mdp_confirm" name = "mdp_confirm">
			<br>

			<label for="email">Nouvelle adresse email:</label> 
			<input type="email" id="email" name = "email">
			<span><em>Ancienne : <c:out value = "${u.getMail()}"/></em></span>
			<br>

			<label for="genre">Genre:</label> 
			<select name="genre" size="1" id = "genre">
			<option>Feminin
			<option>Masculin
			</option>
			<br>
			</select>
			<input
				type='submit' name='submit' value='modifier les informations !'>
		</form>


		<form action="" method="POST">
			<input type='danger' name='submit' value='supprimer votre compte ?'>
		</form>
	</div>
</body>
</html>
