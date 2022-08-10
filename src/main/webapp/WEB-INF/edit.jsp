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
	
	
		<!-- Edit Program Form -->
		<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-1">Edit <c:out value="${program.name}"></c:out></p>
		<form:form action="/new" method="post" modelAttribute="program" class="mx-1 mx-md-4">
		<input type="hidden" name="_method" value="put">
		<form:input type="hidden" name="user" path="user"/>
		<!-- 2 column grid layout with text inputs for the Name and Zip -->
		<div class="row mb-4">
			<div class="col">
				<div class="form-outline">
					<form:label path="name" class="form-label"></form:label>
					<form:input path="name" type="text" class="form-control" placeholder="*Program Name"/> 
					<form:errors path="name" class="text-danger"></form:errors>
				</div>
			</div>
			<div class="col">
				<div class="form-outline">
					<form:label path="zip" class="form-label"></form:label>
					<form:input path="zip" type="number" class="form-control" placeholder="*Zip Code"/> 
					<form:errors path="zip" class="text-danger"></form:errors>
				</div>
			</div>
		</div>

		<!-- URL input -->
		<div class="form-outline mb-4">
			<form:label path="url" class="form-label"></form:label>
			<form:input path="url" type="text" class="form-control" placeholder="Website"/> 
		</div>

		<!-- Email input -->
		<div class="form-outline mb-4">
			<form:label path="email" class="form-label"></form:label>
            <form:input path="email" type="text" class="form-control" placeholder="*Your Email"/>
            <form:errors path="email" class="text-danger"/>
		</div>

		<!-- Phone input -->
		<div class="form-outline mb-4">
			<form:label path="phone" class="form-label"></form:label>
			<form:input path="phone" type="text" class="form-control" placeholder="*Phone Number (###-###-####)"/> 
			<form:errors path="phone" class="text-danger"></form:errors>
		</div>

		<!-- Description input -->
		<div class="form-outline mb-4">
			<form:label path="description" class="form-label"></form:label>
			<form:textarea rows="4" type="text" class="input form-control" path="description" placeholder="*Description"/>
			<form:errors path="description" class="text-danger"/>
		</div>
		
		<!-- Photo Input -->
		<div class="form-outline mb-4">
			<form:label path="photo" class="form-label">Add Photo: </form:label>
			<form:input path="photo" type="file" name="fileImage" accept="image/png, image/jpg"></form:input>
		</div>


		<p>*Field Required</p>
		<!-- Submit button -->
		<button type="submit" class="btn btn-primary btn-block mb-4 shadow" value="submit">Submit</button>
		<a class="btn btn-secondary btn-block mb-4 shadow" href="/dashboard">Cancel</a>
	</form:form>
	
	<div class="d-flex  mx-4 mb-3 mb-lg-4">
	<form action="/programs/delete/${program.id}" method="post">
			<input type="hidden" name="_method" value="delete"> 
			<input type="submit" value="Delete" class="btn btn-danger shadow">
	</form>
	</div>
</body>
</html>