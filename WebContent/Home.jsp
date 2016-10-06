<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Tool.Ruser"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>
	
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
	<br><br><br>
		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<th>Restaurant Name</th>
					<th>Address</th>
					<th>Description</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="restaurants" items="${restaurantsList}">
					<tr>
						<td><c:out value="${restaurants.restaurant.rname}" /></td>
						<td><c:out value="${restaurants.restaurant.address}" /></td>
						<td><c:out value="${restaurants.restaurant.description}" /></td>
						<c:if test="${restaurants.average >-1}">
						<td><c:out value="${restaurants.average}" /></td>
						</c:if>
						<c:if test="${restaurants.average <0}">
						<td> No rating Available</td>
						</c:if>
						<c:if test="${user.userrole=='user'}">
						<td><a
							href="Review?restaurant=<c:out value="${restaurants.restaurant.rid}"/>"><button>Add Review</button></a></td>
						</c:if>	
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

<br><br><br>
</body>
</html>