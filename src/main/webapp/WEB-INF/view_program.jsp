<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- YOUR own local JS -->
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="bg-light">
<!-- Nav Bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-white shadow">
		<div class="container-fluid">
			<img src="/images/OMTLogo.png" class="logo me-2" alt="OMT Logo" href="/" />
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="fw-bold omt" href="#">One More Time!</a>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/dashboard">Home</a></li>
					<c:if test = "${uuid == user.id}">
						<li class="nav-item"><a class="nav-link" href="/new">Add Program</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
					</c:if>
				</ul>
				
				<form class="d-flex input-group w-auto">
					<input type="search" class="form-control" placeholder="Instrument"/>
					<button class="btn btn-outline-primary" type="button" data-mdb-ripple-color="dark">Search</button>
				</form>
			</div>
		</div>
	</nav>
	
	<!-- Program Card -->

	<div class="card mb-3 mt-4 mx-1 mx-md-4">
		<img src="" class="card-img-top" />
		<div class="card-body">
			<h5 class="card-title"><c:out value="${program.name}"></c:out></h5>
			<p class="card-text">Description: <c:out value="${program.description}"></c:out></p>
			<c:if test = "${uuid == user.id}">
		    <p class="card-text">Phone: <c:out value="${program.phone}"></c:out></p>
		    <p class="card-text">Email: <c:out value="${program.email}"></c:out></p>
		    <p class="card-text">Zip: <c:out value="${program.zip}"></c:out></p>
		    </c:if>
			<p class="card-text">
				<small class="text-muted">Last updated by <c:out value="${program.user.user_name}"></c:out> 3 mins ago</small>
			</p>
		</div>
	</div>
	<div>
		<c:if test = "${uuid == program.user.id}">
	    <a href="/programs/${program.id}/edit" class="btn btn-outline-primary btn-md mt-4 ms-4 shadow">Edit</a>
	    </c:if>
	</div>

	
</body>
</html>