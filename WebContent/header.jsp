<meta charset="utf-8">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/global.css">

		<br>
		<div class="page">
			<a href="<%=request.getContextPath()%>/login"><b>Our Blog</b></a>
			<br><br><br>
		</div>

		<div id = "first_bar">
			<span><a href = "<%=request.getContextPath()%>/DeconnexionServlet"><h2>Deconnexion</h2></a></span>
			<div class = "page">
			<form action="<%=request.getContextPath()%>/SearchUserServlet" method="POST">
				<input type = "search" name = "pseudo_user" placeholder="search"> <input
					type="hidden" name="id_user" value="<%=id_user%>" />
					<input	type="submit" name="Publier" value="search"/>
			</form>
		</div>
	<br>
