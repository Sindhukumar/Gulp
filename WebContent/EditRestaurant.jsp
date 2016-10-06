<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Restaurant</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	<form>
		 Name of the Restaurant:<br> <input
			type="text" name="rname" id="rname" value="{sessionScope.currentrest.name}"> <br> Address:<br>
		<input type="text" name="address" id="address"> <br>
		Description: <br> <input type="text" name="description"
			id="description"> <br> <input type="submit"
			value="Submit" id="submit" />
	</form>

</body>
</html>