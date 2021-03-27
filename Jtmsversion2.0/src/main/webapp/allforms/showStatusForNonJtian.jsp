<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
  <link rel="icon" type="image/png" href="img/jtcroped.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Student Informations
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="css/bootstrap.min.css" rel="stylesheet" />
  <link href="css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="logo">
        <a href="http://www.creative-tim.com" class="simple-text logo-mini">
          <div class="logo-image-small">
            <img src="img/jt.jpg">
          </div>
        </a>
        <a href="https://javatechnocrat.com/" class="simple-text logo-normal">
          Java Technocrat
          <!-- <div class="logo-image-big">
            <img src="img/logo-big.png">
          </div> -->
        </a>
      </div>
     <div class="sidebar-wrapper">
        <ul class="nav">
          <li >
            <a href="dashboard">
              <i class="nc-icon nc-bank"></i>
              <p>Home</p>
            </a>
          </li>
          <li class="active">
            <a href="student">
              <i class="nc-icon nc-hat-3"></i>
              <p>Students</p>
            </a>
          </li>
          <li>
            <a href="book">
              <i class="nc-icon nc-book-bookmark"></i>
              <p>Books</p>
            </a>
          </li>
          <li>
            <a href="batch">
              <i class="nc-icon nc-time-alarm"></i>
              <p>Batches</p>
            </a>
          </li>
          <li>
            <a href="placement">
              <i class="nc-icon nc-tile-56"></i>
              <p>Placements</p>
            </a>
          </li>
          <li>
            <a href="enquiry">
              <i class="nc-icon nc-zoom-split"></i>
              <p>Enquiry</p>
            </a>
          </li>
          <li>
            <a href="advertisement">
              <i class="nc-icon nc-alert-circle-i"></i>
              <p>Advertisement</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">A Initiative by Rashmi Sir and Team</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <form>
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <div class="input-group-append">
                  <div class="input-group-text">
                    <i class="nc-icon nc-zoom-split"></i>
                  </div>
                </div>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link btn-magnify" href="#pablo">
                  <i class="nc-icon nc-layout-11"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Stats</span>
                  </p>
                </a>
              </li>
              <li class="nav-item btn-rotate dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="nc-icon nc-bell-55"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Some Actions</span>
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Action</a>
                  <a class="dropdown-item" href="#">Another action</a>
                  <a class="dropdown-item" href="#">Something else here</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link btn-rotate" href="#pablo">
                  <i class="nc-icon nc-settings-gear-65"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <!-- <div class="panel-header panel-header-lg">

  <canvas id="bigDashboardChart"></canvas>


</div> -->
<!-- status displayed 						*******			******					-->
	  <div class="content">
        <div class="row">
          <div class="col-md-12">
       	  	 <div class="card card-user" >
       	  	    <div class="card-header">
                <h5 class="card-title">Enter Student details</h5>
                </div>
       	  	  	<div class="card-body">
	               	 <form action="/showStatus" method="post">
	                 	<div class="row">
	                 	<div class="col-md-6 pr-1">
	                      <div class="form-group">
	                        <label>Student Name</label>
	                        <input type="text" style = "text-transform:capitalize;" class="form-control" placeholder="Student Name" name="searchedName" required="required">
	                      </div>
                    	</div>
                    	 	
	                 	<div class="col-md-6 pr-1">
	                      <div class="form-group">
	                        <label>Email</label>
	                        <input type="text" class="form-control" placeholder="Student Email" name="searchedEmail" required="required">
	                      </div>
                    	</div>
                    	</div>
                    	<div class="row" >
	                    <div class="update ml-auto mr-auto">
						<input type="submit" class="btn btn-success btn-outline-success btn-round btn-wd " value = "Check Student Status">	                    		
	                    </div>	
	                    </div>	

	       	  	  	 </form>
       	  	  	 </div>
       	  	 </div>
       	  </div>
       	
<!-- status displayed end						*******			******					-->
<!-- non jtian form 						*******			******					-->

	
		<div class="col-md-12">
            <div class="card card-user">
              <div class="card-header">
                <div class="text-right" style="padding-right: 20px;">
                    	<p style="color: purple;" id="status">The entity is a Non jtian</p>
                    	</div>
                <h5 class="card-title">Register Your Details</h5>
              </div>
              <div class="card-body">
                <form action="/nonJtianPersonalDetails" method="post">
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>Student name</label>
                        <input type="text" style = "text-transform:capitalize;" class="form-control" placeholder="Enter Your Full Name" name="name" required="required">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="text" class="form-control" name="email" placeholder="Enter a valid Email" required="required">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Mobile Number</label>
                        <input type="number" class="form-control" placeholder="Enter A valid Phone number" name="phone" required="required">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>College Name</label>
                        <input type="text" class="form-control" style = "text-transform:uppercase;" placeholder="Enter College Name" name="college" required="required">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label>Branch</label>
                        <input type="text" class="form-control" style = "text-transform:uppercase;" placeholder="Enter Your Branch" name="branch" required="required">
                      </div>
                    </div>
                    <div class="col-md-2 pl-1">
                      <div class="form-group">
                        <label>Year Of Passing</label>
                        <input type="number" class="form-control" placeholder="Passout Year" name="yop" required="required">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" style = "text-transform:capitalize;" placeholder="Home Address" name="address" required="required">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>Guardian Name</label>
                        <input type="text" class="form-control" style = "text-transform:capitalize;" placeholder="Enter Your Guardian Name" name="guardian_name" required="required">
                      </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Guardian Phone Number</label>
                        <input type="number" class="form-control" placeholder="Enter Your Parent's Phone Number" name="guardian_phone" required="required">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label>Postal Code</label>
                        <input type="number" class="form-control" placeholder="Pin Code" name="pincode" required="required">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
						<input type="submit" class="btn btn-primary btn-outline-primary btn-round btn-wd " value = "Register">
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
		 </div>
		</div>	


<!-- non jtian form end						*******			******					-->
<!-- footer						*******			******					-->						 
      <footer class="footer footer-black  footer-white ">
        <div class="container-fluid">
          <div class="row">
            <nav class="footer-nav">
              <ul>
                <li>
                  <a href="https://www.facebook.com/javatechnocrat/" target="_blank">Facebook</a>
                </li>
                <li>
                  <a href="https://javatechnocrat.com/about.php" target="_blank">About us</a>
                </li>
              </ul>
            </nav>
            <div class="credits ml-auto">
              <span class="copyright">
                ©
                <script>
                  document.write(new Date().getFullYear())
                </script>, made with <i class="fa fa-heart heart"></i> by JT team members
              </span>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>					
  <!--   Core JS Files   -->
  <script src="js/core/jquery.min.js"></script>
  <script src="js/core/popper.min.js"></script>
  <script src="js/core/bootstrap.min.js"></script>
  <script src="plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>
  <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
  <script src="demo/demo.js"></script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
      demo.initChartsPages();
    });
  </script>
</body>

</html>
