<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Navbar</title>
</head>
<body>
	<header class="header">
	<div role="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="#all" class="navbar-brand scroll-to"><img
					src="images/gradebook.png" alt="logo" class="hidden-xs hidden-sm" height="50" width="50"><img
					src="images/gradebook.png" alt="logo" class="visible-xs visible-sm" height="50" width="50"><span
					class="sr-only">Go to homepage</span></a>
				<div class="navbar-buttons">
					<button type="button" data-toggle="collapse"
						data-target=".navbar-collapse" class="navbar-toggle navbar-btn">
						Menu<i class="pe-7s-menu"></i>
					</button>
				</div>
				
			</div>
			<div id="navigation" class="collapse navbar-collapse navbar-right">
				<ul class="nav navbar-nav">
				<li><% if (session.getAttribute("user") != null) { %>
					<a href="Profile.jsp?action=viewprofile"><img
							alt="${user.username}" src="${gravatarURL}" height="30" width="30" />&nbsp;${user.username}</a>
					<% } %></li>
					<li><a href="/Gradebook/Profile.jsp">Edit Profile </a></li>
					<li><a href="/Gradebook/Search.jsp">Search</a></li>
					<li><a href="/Gradebook/support.jsp">Support</a></li>
					<li><a href="/Gradebook/Login.jsp">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	</header>

</body>
</html>