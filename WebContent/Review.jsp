<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Review Restaurant</title>
</head>
<body >

	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	
		<form action="Review" method="post" onsubmit="return verifyPassword()">
<br><br>
			<input id="restaurantid"
				name="restaurantid" type="hidden" value="${restaurant}"   />
				<fieldset>
					<label for="number">Rating</label> 
					<select name="number" id="number">
						<option selected="selected">0</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</fieldset>



				<b>Review:</b><br>
				<textarea name="review" id="review" class="form-control" rows="2"
					placeholder="We value your feedback!" maxlength="200"></textarea>
			</form>
			<button id="submit" type="submit" value="Submit">
				<font color="blue">Submit</font>
			</button>
		</form>
</body>
</html>