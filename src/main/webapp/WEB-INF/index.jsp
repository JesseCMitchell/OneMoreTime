<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One More Time!</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- FontAwesome Icons -->
<script src="https://kit.fontawesome.com/f7c6b3387d.js" crossorigin="anonymous"></script>

</head>
<body class="">
<!-- Nav Bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-white shadow">
		<div class="container-fluid">
			<img src="/images/OMTLogo.png" class="logo me-2" alt="OMT Logo" />
			
			
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="fw-bold omt" href="#">One More Time!</a>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/dashboard">Home</a></li>
					
					<%-- <c:if test = "${uuid == user.id}">
						<li class="nav-item"><a class="nav-link" href="/new">Add Something</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
					</c:if> --%>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/createaccount">Sign Up</a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/createaccount">Log In</a></li>
				</ul>
				<form class="d-flex input-group w-auto">
					<input type="search" class="form-control" placeholder="Instrument"/>
					<button class="btn btn-outline-primary" type="button" data-mdb-ripple-color="dark">Search</button>
				</form>
			</div>
		</div>
	</nav>
	
	
	
	<!-- Hero Content  -->
	<section class="about" id="about">
		<div class="text-block">
			<div class="landing-text">
				<h1 class="support">Support a school music program.</h1>
				<h1 class="recycle">Recycle your old instrument.</h1>
				<br />
				<p class="fs-4">It can take months or years for schools to purchase or repair 
				their aging instrument inventory. Donate your unused instrument and let it be played... 
				<p class="text-break fs-2 fw-bold indigo">One More Time!
				<br />
				 <a href="/createaccount" class="btn btn-primary btn-lg mt-3 rounded-pill">Donate Today</a>
				<p class="text-break fs-4">Your donation can help a school music program that is urgently in need.</p>
			</div>
		</div>
	</section>
	
	<!-- Search Bar -->
	<div class="container">
         <div class="row height d-flex justify-content-center align-items-center mb-4">
           <div class="col-md-8">
             <div class="search">
               <i class="fa fa-search"></i>
               <input type="text" class="form-control" placeholder="Search By Zip">
               <button class="btn btn-primary">Search</button>
             </div>            
           </div>         
         </div>
     </div>
	
	<!-- Featured Programs -->
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<div class="col">
			<div class="card h-100">
				<img src="/images/band4.jpg"
					class="card-img-top" alt="" />
				<div class="card-body">
					<h5 class="card-title">GHS Band</h5>
					<p class="card-text">We are looking for mouthpieces for our woodwind and brass students. Must be clean and in good condition.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 2 days ago</small>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card h-100">
				<img src="/images/band2.jpg"
					class="card-img-top" alt="" />
				<div class="card-body">
					<h5 class="card-title">HL 7-8 Orchestra</h5>
					<p class="card-text">Our students are in need of cases for instruments! If you have a used instrument case - we will gladly accept them!</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 50 mins ago</small>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card h-100">
				<img src="/images/band3.jpg"
					class="card-img-top" alt="" />
				<div class="card-body">
					<h5 class="card-title">VHS Band</h5>
					<p class="card-text">Looking for used low-brass and percussion instruments!</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
		</div>
	</div>

</body>
</html>