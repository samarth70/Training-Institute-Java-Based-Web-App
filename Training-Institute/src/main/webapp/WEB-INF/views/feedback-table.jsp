<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.genpact.dao.FeedbackDAO"%>
<%@page import="com.genpact.pojo.Feedback"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>

<title>Feedback Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Feedback page</title>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!--
			CSS
			============================================= -->

<link rel="stylesheet"
	href="<c:url value="/resources/css/linearicons.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/font-awesome.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/magnific-popup.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/nice-select.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/animate.min.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/owl.carousel.css" /> ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css" /> ">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" /> ">
</head>
<body>
	<header id="header" id="home" class="banner-area relative about-banner">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-8 header-top-left no-padding">
						<ul>
							<li><a href="https://www.facebook.com/"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="https://www.twitter.com/"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="https://www.dribble.com/"><i
									class="fa fa-dribbble"></i></a></li>
							<li><a href="https://www.behance.com/"><i
									class="fa fa-behance"></i></a></li>
						</ul>
					</div>
					<div class="col-lg-6 col-sm-6 col-4 header-top-right no-padding">
						<a href="tel:+91 012 3654 896"><span
							class="lnr lnr-phone-handset"></span> <span class="text">+91
								012 3654 896</span></a> <a href="mailto:support@javagroup2.com"><span
							class="lnr lnr-envelope"></span> <span class="text">support@javagroup2.com</span></a>
					</div>
				</div>
			</div>
		</div>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.jsp"><img src="img/logo.png" alt="" title="" /></a>
				</div>
				<!-- <nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="viewInststudents/${INSTOBJ.instituteID}">View Students</a></li>
                  <li class="menu-has-children"><a href="">Institute</a>
                    <ul>
                      <li><a href="viewinstitutes">View Institutes</a></li>
                      <li><a href="deleteInstituteForm">Delete Institute</a></li>
                    </ul>
                  </li>		
                  <li><a href="showfeedbacks">View Feedbacks</a></li>   
                  <li class="menu-has-children"><a href="">Profile</a>
                  <ul>
                  <li><a href="index.jsp">Logout</a></li>
				</ul>
				</li>
				</ul>
				</nav> -->
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- #header -->
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title"  style="text-align:center;">
				<div >
						<h2>
							<b>Students Feedback List</b>
						</h2>
						<br>
					</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Feedback ID</th>
						<th>FeedbackDate</th>
						<th>Student ID</th>
						<th>Institute ID</th>
						<th>Description</th>


					</tr>
				</thead>
				<tbody>


					<c:forEach items="${lst}" var="item" varStatus="loopCounter">

						<tr>
							<td><c:out value="${item.feedbackID}" /></td>
							<td><c:out value="${item.date}" /></td>
							<td><c:out value="${item.userID}" /></td>
							<td><c:out value="${item.instituteID}" /></td>
							<td><c:out value="${item.description}" /></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<div class="clearfix">
				<ul class="pagination">
					<li class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item active"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item "><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
	<footer>
		<div
			class="footer-bottom row align-items-center justify-content-between">
			<p class="footer-text m-0 col-lg-6 col-md-12">
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved | Made with <i class="fa fa-heart-o"
					aria-hidden="true"></i> by <a href="https://javagroup2.com"
					target="_blank">Java Group 2</a>
			</p>
		</div>
		</div>
	</footer>
	<script
		src="<c:url value="/resources/js/vendor/jquery-2.2.4.min.js" /> "></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" /> "></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="<c:url value="/resources/js/easing.min.js" /> "></script>
	<script src="<c:url value="/resources/js/hoverIntent.js" />"></script>
	<script src="<c:url value="/resources/js/superfish.min.js" /> "></script>
	<script src="<c:url value="/resources/js/jquery.ajaxchimp.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery.magnific-popup.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.tabs.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.nice-select.min.js" />"></script>
	<script src="<c:url value="/resources/js/owl.carousel.min.js" /> "></script>
	<script src="<c:url value="/resources/js/mail-script.js" />"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>

</body>
</html>
