<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
<script>
	window.onload = function() {
		$('#update').hide();
<%if (("editprofile").equals(request.getParameter("action"))) {%>
	$("#useremail").removeAttr("disabled");
		$("#userpassword").removeAttr("disabled");
		$("#username").removeAttr("disabled");
		$("#confirmpassword").removeAttr("disabled");
		$("#zip").removeAttr("disabled");
		$('#update').show();
		$('#confirm').show();
<%}%>
	};

	function verifyPassword() {
		var pass1 = document.getElementById("userpassword").value;
		var pass2 = document.getElementById("confirmpassword").value;
		if (pass1 != pass2) {
			alert("Passwords Do not match");
			document.getElementById("userpassword").style.borderColor = "#E34234";
			document.getElementById("confirmpassword").style.borderColor = "#E34234";
			return false;
		}
		return true;
	}
</script>


</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<center>
		<form action="ProfileServlet" method="post"
			onsubmit="return verifyPassword()">
			<br> <br>
			<h6>Profile Details:</h6>
			<br> Name: &nbsp; <input id="username" name="username"
				type="text" value="${sessionScope.user.username}" disabled /><br>
			<br> <br> Email:&nbsp; <input id="useremail"
				name="useremail" type="text" value="${sessionScope.user.useremail}"
				disabled /><br> <br> <br> Password: &nbsp; <input
				id="userpassword" name="userpassword" type="password"
				value="${sessionScope.user.userpassword}" disabled /><br> <br>

			<p style="display: none;" id="confirm">
				Confirm Password: &nbsp; <input id="confirmpassword"
					name="confirmpassword" type="password"
					value="${sessionScope.user.userpassword}" disabled />
			</p>
			<br> Zip: &nbsp; <input id="zip" name="zip" type="text"
				value="${sessionScope.user.zip}" disabled /><br> <br>
			<button id="update" type="submit" value="Submit"
				style="display: none;">
				<font color="blue">Update</font>
			</button>
		</form>
		<h6>Your Reviews</h6>
	</center>
	&nbsp;&nbsp;
	<c:forEach var="review" items="${reviews}">
		<form action="UpdateReview" method="post">
			<input id="restaurant" name="restaurant" type="text"
				value="${review.restaurant.rname}" disabled/>
				 <input id="restaurantid"
				name="restaurantid" type="hidden" value="${review.restaurant.rid}" />
				<br>
				<fieldset>
			<label for="number">Rating</label> <select name="number" id="number">
				<option selected="selected">${review.rating}</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</fieldset> 
			<textarea name="review" id="review" class="form-control" rows="2"
				placeholder="${review.review}" maxlength="200"></textarea>

			<button id="${review.reviewid} " type="submit" value="Submit">
				<font color="blue">Update</font>
			</button>
		</form>
	</c:forEach>


	<!-- Actual: ${pageContext.session.id}-->
	<div></div>
</body>
</html>