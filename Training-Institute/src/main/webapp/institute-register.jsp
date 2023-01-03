<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Institute Registration Page</title>



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
					<a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About</a></li>
						<li class="menu-has-children"><a href="">Login</a>
							<ul>
								<li><a href="admin-login.jsp">Admin</a></li>
								<li><a href="student-login.jsp">Student</a></li>
								<li><a href="institute-login.jsp">Institute</a></li>
							</ul></li>

						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->
			</div>
		</div>
	</header>
	<!-- #header -->

	<br>
	<br>
	<br>
	<section class="h-100 bg-dark">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card card-registration my-4">
						<div class="row g-0">
							<div class="col-xl-6 d-none d-xl-block">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
									alt="Sample photo" class="img-fluid"
									style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
							</div>
							<div class="col-xl-6">
								<div class="card-body p-md-5 text-black">
									<h3 class="mb-5 text-uppercase">Institute Registration Form</h3>

									<form id="registration_form" action="registerInstitute"
										method="POST">
										
										<div class="form-outline mb-4">
                                            <label class="form-label" for="instituteName">Institute Name</label>
											<input type="text" id="instituteName" name="instituteName"
												class="form-control form-control-lg" required /> <span
												class="error_form" id="name_error_message"></span> 
												
										</div>
										
										<div class="form-outline mb-4">
										<div class="form-outline">
                                            <label>Password</label>	
										<input type="password" id="form_password" name="institutePassword" class="form-control form-control-lg" required="">
											<span class="error_form" id="password_error_message" for="institutePassword"></span>
											
										</div>
										</div>
			
										<div class="form-outline mb-4">
											<div class="form-outline">
                                                <label>Re-Enter Password</label>
											<input type="password" id="form_retype_password" class="form-control form-control-lg" name="" required="">
											<span class="error_form" id="retype_password_error_message"></span>	
										</div>
										</div>
										
									<div class="form-outline mb-4">
                                        <label class="form-label" for="affiliationDate">Affiliation Date</label>
										<input type="date" id="affiliationDate" name="affiliationDate" class="form-control form-control-lg" />
									</div>
									
									<div class="form-outline mb-4">
                                        <label class="form-label" for="address">Address</label>
										<input type="text" id="address"  name="address" class="form-control form-control-lg" />
									</div>
									
									
                                    <div class="form-outline mb-4">
                                        <div class="form-outline ">
                                            <label class="form-label" for="seats">Total No. of seats</label>
                                            <input type="number" id="form_seats" name="seats"
                                                class="form-control form-control-lg" required /> <span
                                                class="error_form" id="seats_error_message"></span> 
                                        </div>
                                        </div>
                                        
                                        <div class="form-outline mb-4">
                                        <div class="form-outline ">
                                            <label class="form-label" for="filledSeats">No. of Filled Seats</label>
                                            <input type="number" id="form_fseats" name="filledSeats"
                                                class="form-control form-control-lg" required /> <span
                                                class="error_form" id="fseats_error_message"></span> 
                                        </div>
                                        

                                    </div>
									
										<input type="submit"
											class="btn btn-block btn-warning btn-large" value="REGISTER">

									</form>

									<br>

									<p class="mb-5 pb-lg-2" style="color: #1e2bb9;">
										Have already an account? <a href="student-login.jsp"
											style="color: #1e2bb9;" class="fw-bold text-body"><u>Login here</u></a>
												</p>
									<p></p>
									<p align="center">
										<a href="#!" class="small text-muted">Terms of use.</a> <a
											href="#!" class="small text-muted">Privacy policy</a>
									</p>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


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


	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="js/easing.min.js"></script>
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.tabs.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/main.js"></script>

	<script type="text/javascript">
		$(function() {

           
			$("#name_error_message").hide();
			 $("#password_error_message").hide();
	         $("#retype_password_error_message").hide();
	         $("#seats_error_message").hide();
	         $("#fseats_error_message").hide();
           

           
			var name_error = false;
			var password_error = false;
			var error_retype_password = false;
			var seats_error = false;
			var fseats_error = false;


            
           
			$("#instituteName").focusout(function() {
				check_sname();
			});
			$("#form_password").focusout(function() {
	            check_password();
	         });
	         $("#form_retype_password").focusout(function() {
	            check_retype_password();
	         });
	         $("#form_seats").focusout(function() {
					check_seats();
				});
	         $("#form_fseats").focusout(function() {
					check_fseats();
				});
            
				
			
			function check_sname() {
				var pattern = /^[a-zA-Z ]*$/;
				var fname = $("#instituteName").val();
				if (pattern.test(fname) && fname !== '') {
					$("#name_error_message").hide();
					$("#instituteName").css("border-bottom", "2px solid #34F458");
				} else {
					$("#name_error_message").html("Should contain only Characters");
					$("#name_error_message").show();
					$("#instituteName").css("border-bottom", "2px solid #F90A0A");
					name_error = true;
				}
			}


	         function check_password() {
	        	 var pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;  
	            	 var ph = $("#form_password").val();
	 				if (pattern.test(ph) && ph !== '') {
	 					$("#password_error_message").hide();
	 					$("#form_password").css("border-bottom", "2px solid #34F458");
	 				} else {
	 					$("#password_error_message").html("Invalid Password");
	 					$("#password_error_message").show();
	 					$("#form_password").css("border-bottom", "2px solid #F90A0A");
	 					password_error = true;
	 				}
					}

	         function check_retype_password() {
	            var password = $("#form_password").val();
	            var retype_password = $("#form_retype_password").val();
	            if (password !== retype_password) {
	               $("#retype_password_error_message").html("Passwords Did not Matched");
	               $("#retype_password_error_message").show();
	               $("#form_retype_password").css("border-bottom","2px solid #F90A0A");
	               error_retype_password = true;
	            } else {
	               $("#retype_password_error_message").hide();
	               $("#form_retype_password").css("border-bottom","2px solid #34F458");
	            }
	         }
			
			
          function check_seats() {
            	 var pattern = /^[1-9][0-9]?$|^100$/;
            	 var ph = $("#form_seats").val();
 				if (pattern.test(ph) && ph !== '') {
 					$("#seats_error_message").hide();
 					$("#form_seats").css("border-bottom", "2px solid #34F458");
 				} else {
 					$("#seats_error_message").html("Invalid Seats");
 					$("#seats_error_message").show();
 					$("#form_seats").css("border-bottom", "2px solid #F90A0A");
 					seats_error = true;
 				}
				}
          
          function check_fseats() {
         	 var pattern = /^[1-9][0-9]?$|^100$/;
         	 var ph = $("#form_fseats").val();
				if (pattern.test(ph) && ph !== '') {
					$("#fseats_error_message").hide();
					$("#form_fseats").css("border-bottom", "2px solid #34F458");
				} else {
					$("#fseats_error_message").html("Invalid Seats");
					$("#fseats_error_message").show();
					$("#form_fseats").css("border-bottom", "2px solid #F90A0A");
					fseats_error = true;
				}
				}
            	
            	 
			$("#registration_form").submit(
					function() {
						name_error = false;
						password_error = false;
			            error_retype_password = false;
                        seats_error = false;
                        fseats_error=false;
						
						 check_sname();
						 check_password();
				         check_retype_password();
                         check_seats();
                         check_fseats();

						if (name_error === false && password_error === false &&
								error_retype_password === false && seats_error === false && fseats_error === false) {
							alert("Registration Successful");
							return true;
							
						} else {
							alert("Please Fill the Form Correctly");
							return false;
						}

					});
		});
	</script>

</body>
</html>