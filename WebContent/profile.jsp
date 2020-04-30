<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.User" import="model.UserMySQLDao"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% boolean is_friend = (boolean) request.getAttribute("is_friend");
    boolean its_me = (boolean) request.getAttribute("its_me");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil utilisateur</title>
</head>
<body>

	<div id="haut">
		<span><a href="<%=request.getContextPath()%>/IndexServlet">Retour</a></span>
		<h1>Profil</h1>
	</div>

	<div id="contenu">
		<span>Pseudo : ${c_user.getPseudo()}</span> <span>Nom :
			${c_user.getLastname()}</span> <span>Prenom :
			${c_user.getFirstname()}</span> <span>Age : ${c_user.getAge()}</span> <span>Email
			: ${c_user.getMail()}</span> <span>Genre : ${c_user.getGenre()}</span>
	</div>

	<div id="add_delete_friend">
		<%if (its_me == true) {%>
			<a href="<%=request.getContextPath()%>/ChangeAccountInformationServlet"
			class="bouton1">Modifier vos informations</a>
		<%} else {%>
		<% if( is_friend == true) {%>
		<a
			href="<%=request.getContextPath()%>/UnfollowServlet?userU=${c_user.getId()}"
			class="bouton1">Ne plus suivre</a>
		<%} else {%>
		<a
			href="<%=request.getContextPath()%>/FollowServlet?userF=${c_user.getId()}"
			class="bouton2">Suivre</a>
		<%} %>
		<%} %>
	</div>

</body>
</html>