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

<jsp:include page="header.jsp">

	<title>Our Blog</title></head>
</head>
<body>
	
	<div id = "first_bar">
		<span><a href = "<%=request.getContextPath()%>/DeconnexionServlet">Deconnexion</a></span>
		<div id = "search_user">
		<form action="<%=request.getContextPath()%>/SearchUserServlet" method="POST">
			<input type = "text" name = "pseudo_user" > <input
				type="hidden" name="id_user" value="<%=id_user%>" /> <input
				type="submit" name="Publier" />
		</form>
	</div>
		<span><a href = "<%=request.getContextPath()%>/ChangeAccountInformationServlet">Compte</a></span>
	</div>
	
	<!-- Creation de post -->
	<div id = "create_post">
		<form action="<%=request.getContextPath()%>/PostServlet" method="POST">
			<textarea name="post"> Nouveau post </textarea> <input
				type="hidden" name="id_user" value="<%=id_user%>" /> <input
				type="submit" name="Publier" />
		</form>
	</div>

	<!-- Affichage de tous les posts et commentaires des amis -->
	<div id = "all_posts">
		<%
			for (Post p : posts) {
		%>
		<br>
		<div>
			<%
				User p_user = ud.getUser(p.getIdUser());
			%>
			<span><a
				href="<%=request.getContextPath()%>/ProfilServlet?user=<%=p_user.getId()%>"><%=p_user.getPseudo()%>
					:</a></span>
			<textarea rows=5 cols=40><%=p.getMsg()%></textarea>

			<span><%=p.getDate()%></span>

			<%
				List<Commentaire> comments = new ArrayList<Commentaire>();
					p.setCommentsList();
					comments = p.getCommentsList();
					if (comments.isEmpty()) {
			%>
			<span>Aucun commentaire</span>
			<%
				} else {
			%>
			<div id="commentaires">
				<span>Commentaires : </span>
				<%
					for (Commentaire comm : comments) {
				%>
				<div>
					<%
						User c_user = ud.getUser(comm.getIdUser());
					%>
					<span><a
						href="<%=request.getContextPath()%>/ProfilServlet?user=<%=c_user.getId()%>"><%=c_user.getPseudo()%>
							: </a></span>
					<textarea rows=5 cols=40><%=comm.getMsg()%></textarea>

					<span><%=comm.getDate()%></span>

				</div>
				<%
					}
				%>
			</div>
			<%
				}
			%>

			<div>
				<form action="<%=request.getContextPath()%>/CommentaireServlet" method="POST">
					<input type="textarea" name="commentaire"> Ecrivez un
					commentaire </input> <input type="hidden" name="id_post"
						value="<%=p.getId()%>" /> <input type="hidden" name="id_user"
						value="<%=id_user%>" /> <input type="submit" name="Ajouter" />
				</form>
			</div>

		</div>
		<%
			}
		%>


	</div>



</body>


<jsp:include page="footer.jsp"></html>
