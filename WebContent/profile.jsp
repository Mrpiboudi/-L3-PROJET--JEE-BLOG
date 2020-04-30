<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.User" import="dao.UserMySQLDao"
	import = "javax.servlet.http.HttpSession"%>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/global.css"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	boolean is_friend = (boolean) request.getAttribute("is_friend");
	boolean its_me = (boolean) request.getAttribute("its_me");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<head><title>Profil utilisateur</title></head>
<body>
	<br>
	<div class="page">
		<a href="<%=request.getContextPath()%>/login"><b>Our Blog</b></a> <br>
		<br>
		<br>
	</div>

	<div id="first_bar">
		<span><a
			href="<%=request.getContextPath()%>/IndexServlet"><h2>Deconnexion</h2></a></span>
		<div class="page">
			<form action="<%=request.getContextPath()%>/SearchUserServlet"
				method="POST">
				<input type="search" name="pseudo_user" placeholder="search">
				<input type="hidden" name="id_user" value="${id_user}" /> <input
					type="submit" name="Publier" value="search" />
			</form>
		</div>
		<br>

		<div id="haut">
			<span><a href="<%=request.getContextPath()%>/IndexServlet">Retour</a></span>
			<h1>Profil</h1>
		</div>
		<div class="page">
			<div class="inaBox">
				<table>
					<tr>
						<td><h1>Pseudo : ${c_user.getPseudo()}</h1></td>
						<td><h1>Nom :${c_user.getLastname()}</h1></td>
						<td><h1>Prenom :${c_user.getFirstname()}</h1></td>
					</tr>
					<tr>
						<td><h1>Age : ${c_user.getAge()}</h1></td>
						<td><h1>Email : ${c_user.getMail()}</h1></td>
						<td><h1>Genre : ${c_user.getGenre()}</h1></td>
					</tr>
				</table>
			</div>

			<div id="add_delete_friend">
				<%
					if (its_me == true) {
				%>
				<a
					href="<%=request.getContextPath()%>/ChangeAccountInformationServlet"><h1>Modifier
						vos informations</h1></a>
				<%
					} else {
				%>
				<br>
				<%
					if (is_friend == true) {
				%>
				<a
					href="<%=request.getContextPath()%>/UnfollowServlet?userU=${c_user.getId()}"><h1>Ne
						plus suivre</h1></a>
				<%
					} else {
				%>
				<a
					href="<%=request.getContextPath()%>/FollowServlet?userF=${c_user.getId()}"><h1>Suivre</h1></a>
				<%} %>
				<%} %>
			</div>
		</div>
</body>
</html>
