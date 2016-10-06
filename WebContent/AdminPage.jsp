<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<jsp:include page="bootstrapStudent.jsp"></jsp:include>

	<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body>
<br>
<center>
<h2>Hello Admin</h2>
<h3>Please enter new restaurant details</h3>
		<br> <br>

		<form action="AdminServlet" method="post">
			Name of the Restaurant:<br> <input type="text" name="rname" id="rname">
			<br> 
			Address:<br> <input type="text" name="address" id="address">
			<br> 
			Description: <br> <input type="text" name="description" id="description">
			<br> 
						 <input type="submit" value="Submit" id="submit" />		</form>
				<br> <br> <br><br> <br> <br><br> <br> <br>	<br> <br> <br><br> <br> <br>
				</center>
</body>
</html>