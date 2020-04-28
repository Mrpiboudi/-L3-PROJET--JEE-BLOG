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

	<title>Profile</title></head>
</head>
<body>
	<div class="inaBox">
		<h1><%=User.getName%></h1>
		<div>
			<a>age : <%=User.getAge%></a> <a>sexe : <%=User.getSexe%></a> <a>email
				: <%=User.getEmail%></a>
		</div>
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
	<div class="inaBox">
		<%
			ArrayList<User> friendList = current_user.getFriendList();
			if (friendList.size() > 0) {
				for (User friend : friendList) {
		%>
		<a href="<%=request.getContextPath()%>/profile"><h1><%=friend.getName()%></h1></a>

		<%
			}
			} else {
		%>
		<div style="text-align: center;">Aucun ami</div>
		<%
			}
		%>
	</div>
	<!-- Montre les post de l'user -->

	<%
		ArrayList<Post> allPost = current_user.getPost();
		if (allPost.size() > 0) {
			for (Post post : allPost) {
	%>

	<div class="inaBox">
		<a href="<%=request.getContextPath()%>/profile">
		<div class="description"> <%=post.getUser.getName()%></div></a>
		<%
			ArrayList<Comment> comment = post.getComment();
		%>
		<%=comment.toString%>
		<div class="description">
			<%=post.getDate()%>
		</div>
	</div>


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
