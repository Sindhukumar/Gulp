<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<jsp:include page="bootstrapStudent.jsp"></jsp:include>

	<jsp:include page="navbar.jsp"></jsp:include>
	<center>
	<br>
	<br>
	<br>
	<br><br><br><br><br>
	<form action="LoginPageServlet" method="post">

		UserEmail:<input type="text" name="useremail"
			id="useremail"> <br><br> Password: <input
			type="password" name="userpassword" id="userpassword"> <br>
		<br> <input type="submit" value="Submit" id="submit" />
	</form>
	</center>
</body>
</html>