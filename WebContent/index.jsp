<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.User"%>
<%
//ArrayList<Commentaire> comments = getComments()
String current_username = (String)request.getSession().getAttribute("userName");
User current_user = User.getUser(current_user);
%>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="header.jsp">

	<title>Our Blog</title></head>
</head>
<body>

	<!-- intéraction pour ajouter un commentaire -->

	<div class="page">
		<h1>ecrit qlq chose</h1>
		<form action="" method="POST">
			<div>
				<textarea type='textarea' name='commentaire'>comments</textarea>
			</div>
			<div>
				<input type='submit' name='submit' value='poster !'>
			</div>
		</form>
		<br>
	</div>
	<!-- Montre tous le flux d'un user -->


	<%
		ArrayList<Post> allPost = current_user.getAllPost();
		if(allPost.size()>0) {
			for(Post post: allPost) {%>
	<div class="inaBox">
		<a href="<%=request.getContextPath()%>/profile">
		<div class="description"> <%=post.getUser.getName()%></div></a>
		<% ArrayList<Comment> comment = post.getComment();%>
		<%= comment.toString %>
		<div class="description">
			<%= post.getDate() %>
		</div>
	</div>
	<%}
		}
		else { %>
	<div class="h1">Aucun post</div>
	<% } %>

</body>

<jsp:include page="footer.jsp"></html>
