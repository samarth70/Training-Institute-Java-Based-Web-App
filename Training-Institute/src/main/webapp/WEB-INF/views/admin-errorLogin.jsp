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
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Admin Login Form</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
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
			  				<a href="tel:+91 012 3654 896"><span class="lnr lnr-phone-handset"></span> <span class="text">+91 012 3654 896</span></a>
			  				<a href="mailto:support@javagroup2.com"><span class="lnr lnr-envelope"></span> <span class="text">support@javagroup2.com</span></a>			
			  			</div>
			  		</div>			  					
	  			</div>
			</div>
		    <div class="container main-menu">
		    	<div class="row align-items-center justify-content-between d-flex">
			      <div id="logo">
			        <a href="index.jsp"><img src="img/logo.png" alt="" title="" /></a>
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
			            </ul>
			          </li>						          					          		          
			          <li><a href="contact.jsp">Contact</a></li>
			        </ul>
			      </nav><!-- #nav-menu-container -->		    		
		    	</div>
		    </div>
		  </header><!-- #header -->
          
<br><br>			  

			<!-- Start top-category-widget Area -->
            <div class="container">
			<section class="top-category-widget-area pt-90 pb-90 ">
			
                <section class="vh-100" style="background-color: #9A616D;">
                    <div class="container py-5 h-100">
                      <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col col-xl-10">
                          <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                              <div class="col-md-6 col-lg-5 d-none d-md-block">
                                <img
                                  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                  alt="login form"
                                  class="img-fluid" style="border-radius: 1rem 0 0 1rem;"
                                />
                              </div>
                              <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">
                                
                                <div class="alert alert-danger" role="alert">
                                <h4 class="heading" style="color:crimson;">Incorrect Admin ID or Password !!! </h4>
                                </div>
                  
                                 <br>
                  
                                  <form  class="form" action="acceptAdmin" method="GET">
                  
                                    <div class="d-flex align-items-center mb-3 pb-1">
								
                                      <i class="fa fa-cubes fa-2x me-3" style="color: #9A616D;"></i>
                                      <span class="h1 fw-bold mb-0">Admin Login</span>
                                    </div>
                  
                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>
                  
                                    <div class="form-outline mb-4">
                                      <input type="text" id="adminID" name="adminID" class="form-control form-control-lg" />
                                      <label class="form-label" for="adminID">Admin ID</label>
                                    </div>
                  
                                    <div class="form-outline mb-4">
                                      <input type="password" id="adminPassword" name="adminPassword" class="form-control form-control-lg" />
                                      <label class="form-label" for="adminPassword">Admin Password</label>
                                    </div>
                  
                                      <input type="submit" class="btn btn-block btn-danger btn-large"  value="LOGIN" >
                
                  
                                    <!--<a class="small text-muted" href="#!">Forgot password?</a>-->
                                    <!-- <p class="mb-5 pb-lg-2" style="color: #9A616D;">Don't have an account? <a href="#!" style="color: #9A616D;;">Register here</a></p> -->
									<p></p>
									<br>
									<p align="center">
                                    <a href="#!" class="small text-muted">Terms of use.</a>
                                    <a href="#!" class="small text-muted">Privacy policy</a>
								</p>
                                  </form>
                  
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </section>
                </div>

					<div class="footer-bottom row align-items-center justify-content-between">
                    <p class="footer-text m-0 col-lg-6 col-md-12">
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://javagroup2.com" target="_blank">Java Group 2</a>
                    </p>
                </div>						
            </div>
        </footer>	
			<!-- End footer Area -->	


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
		</body>
	</html>

