<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.first_name}'s Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- FontAwesome Icons -->
<script src="https://kit.fontawesome.com/f7c6b3387d.js" crossorigin="anonymous"></script>
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
	
	<h1 class="text-center mb-4 mt-4">Hello <c:out value="${user.first_name} ${user.last_name}"></c:out>. Welcome to your dashboard!</h1>
	
	<!-- Search Bar -->
	<div class="container ">
         <div class="row height d-flex justify-content-center align-items-center mb-4 mx-1 mx-md-4">
           <div class="col-md-8">
             <div class="search">
               <i class="fa fa-search"></i>
               <input type="text" class="form-control" placeholder="Search By Zip">
               <button class="btn btn-primary">Search</button>
             </div>            
           </div>         
         </div>
     </div>

	<!-- Main Dashboard View All Programs -->

	<c:forEach var="program" items="${programs}">
		<div class="card mt-4 mx-2 mx-md-5" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="/images/vader-roomba.png" alt="" class="img-fluid rounded-start" />
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title"><c:out value="${program.name}"></c:out></h5>
						<p class="card-text"><c:out value="${program.description}"></c:out></p>
						<p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
						<p class="fw-normal mb-1"><a href="/programs/${program.id}">View More</a>
						<c:if test = "${uuid == user.id}"><a href="/programs/${program.id}/edit" class="fw-normal mb-1"> | Edit</a></c:if>
						</p>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>
		
	<!-- YOUR own local JS -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- jQuery -->
<script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>