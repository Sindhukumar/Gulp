<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome to Gulp</h1>
		<h3>Please enter your Sign-up details</h3>
		<br> <br>

		<form action="NewUserSignUpServlet" method="post">
			Name:<br> <input type="text" name="username" id="username">
			<br> 
			User Email:<br> <input type="text" name="useremail" id="useremail">
			<br> 
			Password:<br> <input type="password" name="password" id="password" >
				<br> <br> <br>
			Zip: <br> <input type="text" name="zip" id="zip">
			<br> 
						 <input type="submit" value="Submit" id="submit" />		</form>
				<br> <br> <br><br> <br> <br><br> <br> <br>	<br> <br> <br><br> <br> <br>
</center>
</body>
</html>