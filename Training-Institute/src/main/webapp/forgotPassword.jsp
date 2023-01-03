<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="simran">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Forgot Password Page</title>

	<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
	<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="<c:url value="/resources/css/linearicons.css"/>">
			<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">
			<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" /> ">
			<link rel="stylesheet" href="<c:url value="/resources/css/magnific-popup.css" /> ">
			<link rel="stylesheet" href="<c:url value="/resources/css/nice-select.css" /> ">							
			<link rel="stylesheet" href="<c:url value="/resources/css/animate.min.css" /> ">
			<link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.css" /> ">			
			<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" /> ">			
			<link rel="stylesheet" href="<c:url value="/resources/css/main.css" /> ">
			
</head>

<body>
	<header id="header" id="home" class="banner-area relative about-banner">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-8 header-top-left no-padding">
						<ul>
							<li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
							<li><a href="https://www.twitter.com/"><i class="fa fa-twitter"></i></a></li>
							<li><a href="https://www.dribble.com/"><i class="fa fa-dribbble"></i></a></li>
							<li><a href="https://www.behance.com/"><i class="fa fa-behance"></i></a></li>
						</ul>
					</div>
					<div class="col-lg-6 col-sm-6 col-4 header-top-right no-padding">
						<a href="tel:+91 012 3654 896"><span class="lnr lnr-phone-handset"></span> <span
								class="text">+91 012 3654 896</span></a>
						<a href="mailto:support@javagroup2.com"><span class="lnr lnr-envelope"></span> <span
								class="text">support@javagroup2.com</span></a>
					</div>
				</div>
			</div>
		</div>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
				</div>
				<!-- <nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li class="menu-has-children"><a href="">Sign in</a>
							<ul>
								<li><a href="admin-login.jsp">Admin</a></li>
								<li><a href="student-login.jsp">Student</a></li>
								<li><a href="institute-login.jsp">Institute</a></li>
							</ul>
						</li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</nav><!-- #nav-menu-container -->
			</div>
		</div>
	</header><!-- #header -->

	<br><br>

	<!-- End banner Area -->

	<div class="container">
		<section class="top-category-widget-area pt-90 pb-60 ">
			<div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
				<div class="d-table-cell align-middle">

					<div class="text-center mt-4">
						<h1 class="h2">Reset password</h1>

						<p class="lead">
							Enter your email to reset your password.
						</p>
					</div>

					<div class="card">
						<div class="card-body">
							<div class="m-sm-4">
								<form id="registration_form">
									<div class="form-group">
										<!-- <label>Email</label> -->
										<input class="form-control form-control-lg" type="email" id="form_email" name=""
											placeholder="Enter your Email">
										<span class="error_form" id="email_error_message"></span>
									</div>

									<div class="d-flex justify-content-center">
										<input type="submit" class="btn btn-block btn-danger btn-large" onclick="function();"
											value="Reset Password">
									</div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>

		</section>
	</div>




	<script src="<c:url value="/resources/js/vendor/jquery-2.2.4.min.js" /> "></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" /> " ></script>			
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
  			<script src="<c:url value="/resources/js/easing.min.js" /> "></script>			
			<script src="<c:url value="/resources/js/hoverIntent.js" />"></script>
			<script src="<c:url value="/resources/js/superfish.min.js" /> "></script>	
			<script src="<c:url value="/resources/js/jquery.ajaxchimp.min.js" />"></script>
			<script src="<c:url value="/resources/js/jquery.magnific-popup.min.js" />"></script>	
    		<script src="<c:url value="/resources/js/jquery.tabs.min.js" />"></script>						
			<script src="<c:url value="/resources/js/jquery.nice-select.min.js" />"></script>	
			<script src="<c:url value="/resources/js/owl.carousel.min.js" /> "></script>									
			<script src="<c:url value="/resources/js/mail-script.js" />"></script>	
			<script src="<c:url value="/resources/js/main.js" />"></script>	


	<script type="text/javascript">
		$(function () {

			$("#email_error_message").hide();

			var error_email = false;

			$("#form_email").focusout(function () {
				check_email();
			});




			function check_email() {
				var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
				var email = $("#form_email").val();
				if (pattern.test(email) && email !== '') {
					$("#email_error_message").hide();
					$("#form_email").css("border-bottom", "2px solid #34F458");
				} else {
					$("#email_error_message").html("Invalid Email");
					$("#email_error_message").show();
					$("#form_email").css("border-bottom", "2px solid #F90A0A");
					error_email = true;
				}
			}

			$("#registration_form").submit(function () {
				error_email = false;

				check_email();

				if (error_email === false) {
					alert("Email Successfully Sent");
					return true;
				} else {
					alert("Please Enter the email Correctly");
					return false;
				}


			});
		});
	</script>

</body>

</html>