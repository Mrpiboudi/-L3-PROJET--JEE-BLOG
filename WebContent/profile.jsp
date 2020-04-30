<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8" import="model.User" import="model.UserMySQLDao"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	boolean is_friend = (boolean) request.getAttribute("is_friend");
	boolean its_me = (boolean) request.getAttribute("its_me");
%>
=======
	pageEncoding="UTF-8"%>
>>>>>>> 2f83ac611a361001ad2ad57c4764f421a3931e5a

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp">
	


	<title>Vos informations</title></head>
<body>
	
		<br>
		<div class="page">
			<a href="<%=request.getContextPath()%>/login"><b>Our Blog</b></a>
			<br><br><br>
		</div>

	<div id = "haut">
		<span>	<a href = "<%=request.getContextPath()%>/ProfileServlet"><h2>Retour</h2></a>	<span>
		<h1>Modifications de vos informations</h1>

	</div>

	<div class="page">
		<form action="" method="POST">
			<div>
			<label for="pseudo"/>
			<input type="text" id="pseudo" name = "pseudo" placeholder="modifier pseudo"><br>
			<span><em><div class="description">Ancien pseudo : </div><c:out value = "${u.getPseudo()}"/></em></span>
			</div>
			<br>
			<div>
			<label for="nom"/>
			<input type="text" id="nom" name = "nom" placeholder="modifier nom"><br>
			<span><em><div class="description">Ancien nom : </div><c:out value = "${u.getLastname()}"/></em></span>
			</div>
			<br>
			<div>
			<label for="prenom"/>
			<input type="text" id="prenom" name = "prenom" placeholder="modifier prenom"><br>
			<span><em><div class="description">Ancien prenom : </div><c:out value = "${u.getFirstname()}"/></em></span>
			</div>
			<br>
<div>
			<label for="age"/>
			<input type=text id="age" name ="age" placeholder="modifier age"><br>
			<span><em><div class="description">Ancien age : </div><c:out value = "${u.getAge()}"/></em></span>
</div>
			<br>

<<<<<<< HEAD
	<div id="add_delete_friend">
		<%
			if (its_me == true) {
		%>
		<a
			href="<%=request.getContextPath()%>/ChangeAccountInformationServlet"
			class="bouton1">Modifier vos informations</a>
		<%
			} else {
		%>
		<%
			if (is_friend == true) {
		%>
		<a
			href="<%=request.getContextPath()%>/UnfollowServlet?userU=${c_user.getId()}"
			class="bouton1">Ne plus suivre</a>
		<%
			} else {
		%>
		<a
			href="<%=request.getContextPath()%>/FollowServlet?userF=${c_user.getId()}"
			class="bouton2">Suivre</a>
		<%
			}
		%>
		<%
			}
		%>
	</div>
=======
<div>
			<label for="mdp"/>
			<input type="password" id="mdp" name = "mdp" placeholder="nouveau mot de passe">
</div>
<br>
	<div>
			<label for="mdp_confirm"/>
			<input type="password" id="mdp_confirm" name = "mdp_confirm" placeholder="confirmer mot de passe">
</div>
			<br>
<div>
			<label for="email"/>
			<input type="email" id="email" name = "email" placeholder="modifier email"><br>
			<span><em><div class="description">Ancienne addresse: </div><c:out value = "${u.getMail()}"/></em></span>
</div>
			<br>
<div>
			<label for="genre"/>
			<select name="genre" size="1" id = "genre">
			<option><div class="description">Feminin</div>
			<option><div class="description">Masculin</div>
			</option>
		</div>
			<br>
				<div>
			</select>
			<input
				type='submit' name='submit' value='modifier les informations !'>
				</div>
		</form>
>>>>>>> 2f83ac611a361001ad2ad57c4764f421a3931e5a


		<form action="" method="POST">
			<input color='rgb(248, 93, 44)' type='submit' name='submit' value='supprimer votre compte ?' >
		</form>
	</div>
</body>
</html>
