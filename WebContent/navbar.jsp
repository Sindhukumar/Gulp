<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					src="images/gulp.jpg" alt="logo" class="hidden-xs hidden-sm"
					height="50" width="150"><img src="images/gradebook.png"
					alt="logo" class="visible-xs visible-sm" height="50" width="50"><span
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

					<c:if test="${user!=null}">
						<li><a href="Profile.jsp?action=viewprofile"><img
								alt="${user.username}" src="${gravatarURL}" height="30"
								width="30" />&nbsp;${user.username}</a></li>

					<c:if test="${user.userrole=='Admin'}">
					<li><a href="/AddRestaurant.jsp">Add Restaurant </a></li>
					</c:if>

						<li><a href="/Profile.jsp">Edit Profile </a></li>

						<li><a href="/support.jsp">Support</a></li>

						<li><a href="/Home">Logout</a></li>
					</c:if>
					
					<c:if test="${user==null}">
					<li><a href="/Signup.jsp">Sign up</a></li>

					<li><a href="/Signin.jsp">Sign in</a></li>
					</c:if>
					
				</ul>
			</div>
		</div>
	</div>
	</header>

</body>
</html>