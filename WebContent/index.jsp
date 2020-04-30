<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.User" import="model.Post"
	import="model.Commentaire" import="java.util.List"
	import="java.util.ArrayList" import="dao.UserMySQLDao"%>

<%
	ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("allPosts");
	int id_user = (Integer) request.getAttribute("id_user");

	int id_post;

	UserMySQLDao ud = new UserMySQLDao();
	User user = ud.getUser(id_user);
%>

<!DOCTYPE html>
<html>
<head>

<!--<jsp:include page="header.jsp">-->

	<title>Our Blog</title></head>
<body>

	<br>
	<div class="page">
		<a href="<%=request.getContextPath()%>/IndexServlet"><b>Our
				Blog</b></a> <br> <br> <br>
	</div>

	<div id="first_bar">
		<span><a
			href="<%=request.getContextPath()%>/DeconnexionServlet"><h2>Deconnexion</h2></a></span>
		<div class="page">
			<form action="<%=request.getContextPath()%>/SearchUserServlet"
				method="POST">
				<input type="search" name="pseudo_user" placeholder="search">
				<input type="hidden" name="id_user" value="<%=id_user%>" /> <input
					type="submit" name="Publier" value="search" />
			</form>
		</div>
		<br> <a
			href="<%=request.getContextPath()%>/ProfilServlet?user=<%=id_user%>"><h1>Compte</h1></a>
	</div>
	<div class="page">
		<!-- Creation de post -->
		<div class="inaBox">
			<form action="<%=request.getContextPath()%>/PostServlet"
				method="POST">
				<div>
					<textarea type='textarea' name="post" placeholder="nouveau Post"></textarea>
				</div>
				<div>
					<input type="hidden" name="id_user" value="<%=id_user%>" /> <input
						type="submit" name="Publier" value="post" />
				</div>
			</form>
		</div>

		<!-- Affichage de tous les posts et commentaires des amis -->
		<div class="inaBox">
			<%
				for (Post p : posts) {
			%>
			<br>
			<div>
				<%
					User p_user = ud.getUser(p.getIdUser());
				%>

				<a
					href="<%=request.getContextPath()%>/ProfilServlet?user=<%=p_user.getId()%>"><class="description"><%=p_user.getPseudo()%>
					:</class="description"></a>
				<div>
					<textarea type="textarea" rows=5 cols=40><%=p.getMsg()%></textarea>
				</div>

				<div class="description"><%=p.getDate()%></div>

				<%
					List<Commentaire> comments = new ArrayList<Commentaire>();
						p.setCommentsList();
						comments = p.getCommentsList();
						if (comments.isEmpty()) {
				%>
				<h1>Aucun commentaire</h1>
				<%
					} else {
				%>
				<div class="inaBox">
					<h1>Commentaires :</h1>
					<%
						for (Commentaire comm : comments) {
					%>

					<%
						User c_user = ud.getUser(comm.getIdUser());
					%>

					<a
						href="<%=request.getContextPath()%>/ProfilServlet?user=<%=c_user.getId()%>"><div
							class="description"><%=c_user.getPseudo()%>
							:</a> <span><%=comm.getDate()%></span>
				</div>
				<div>
					<textarea type="commentaire" rows=5 cols=40><%=comm.getMsg()%></textarea>
				</div>

				<%
					}
				%>

				<%
					}
				%>


				<form action="<%=request.getContextPath()%>/CommentaireServlet"
					method="POST">
					<input type="post" name="commentaire" placeholder="comments..">
					</textarea>
					<input type="hidden" name="id_post" value="<%=p.getId()%>" /> <input
						type="hidden" name="id_user" value="<%=id_user%>" /> <input
						type="submit" name="Ajouter" value="commenter" />
				</form>


			</div>
			<%
			}
		%>


		</div>
	</div>


</body>


<jsp:include page="footer.jsp"></html>
