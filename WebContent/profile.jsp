<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String current_username = (String) request.getSession().getAttribute("userName");
	User current_user = User.getUser(current_user);

%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp">

	<title>Profile de <%=current_username%></title></head>
<meta charset="UTF-8">
</head>
<body>
	<div>
		<div>
			<a>information :</a>
		</div>
		<%=User.getInformation%>
	</div>

	<%
		if (current_username == (String) request.getSession().getAttribute("userName")) {
	%>
	<a href="<%=request.getContextPath()%>/changeAccountInformation">Modifier
		vos information</a>
	<%
		}
	%>

<!-- Montre la liste d'ami l'user -->

	<%
	ArrayList<User> friendList = current_user.getFriendList();
	if (friendList.size() > 0) {
			for (User friend : friendList) {
	%>
	<div class="login-logo">
		<a href="<%=request.getContextPath()%>/profile"><%=friend.getName()%></a>
	</div>
	<%
		}
		} else {
	%>
	<div style="text-align: center;">Aucun ami</div>
	<%
		}
	%>
	
	<!-- Montre les post de l'user -->

	<%
		ArrayList<Post> allPost = current_user.getPost();
		if (allPost.size() > 0) {
			for (Post post : allPost) {
	%>
	<%=post.getDate()%>
	<%
		ArrayList<Comment> comment = post.getComment();
	%>
	<%=comment.toString%>
	<%
		}
		} else {
	%>
	<div style="text-align: center;">Aucun post pour le moment</div>
	<%
		}
	%>


</body>
</html>