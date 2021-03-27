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
    Books Informations
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" rel="stylesheet/javascript"></script>
  
  <link href="css/bootstrap.min.css" rel="stylesheet" />
  <link href="css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
  
  <!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
  <link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" />
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script> 
  
  
  <script type="text/javascript">

  	$(document).ready( function () {
	    $('#display').DataTable();
	    $('#display1').DataTable();
	} );
  	
 </script>
 
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
          <li>
            <a href="student">
              <i class="nc-icon nc-hat-3"></i>
              <p>Students</p>
            </a>
          </li>
          <li >
            <a href="book">
              <i class="nc-icon nc-book-bookmark"></i>
              <p>Books</p>
            </a>
          </li>
          <li class="active ">
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
<!-- 				**************						Add A Subject -->
<div class="content">
<div class="row">
          <div class="col-md-5 pr-1" >
       	  	 <div class="card card-user">
       	  	    <div class="card-header">
                <h5 class="card-title" style="padding-left: 5px">Add A Subject</h5>
                </div>
       	  	  	<div class="card-body">
	               	 <form action="/addedSubject" method="post">
	                 	<div class="row">
	                 	<div class="col-md-8 pr-1">
	                      <div class="form-group">
	                        <label>Subject Name</label>
	                        <input type="text" style = "text-transform:capitalize;" class="form-control" placeholder="Enter Subject Name" name="name" required="required">
	                      </div>
                    	</div>
                    	 	
	                 	<div class="col-md-5 pr-1">
	                      <div class="form-group">
	                        <label>Course Fee</label>
	                        <input type="number" class="form-control" placeholder="Enter Subject Price" name="fee" required="required">
	                      </div>
                    	</div>
                    	</div>
                    	
                    	<div class="row">	
                    		<div class="update ml-auto mr-auto">
                    			<input type="submit" class="btn btn-success btn-outline-success btn-round btn-wd " value = "Add">
                    		</div>
                    	</div>
	       	  	  	 </form>
       	  	  	 </div>
       	  	 </div>
       	  </div>
       	  
  	  
<!-- Add A Batch -->       	
          <div class="col-md-7">
       	  	 <div class="card card-user">
       	  	    <div class="card-header">
                <h5 class="card-title" >Add A Batch</h5>
                </div>
       	  	  	<div class="card-body">
	               	 <form action="/addedBatch" method="post">
	                 	<div class="row">
	                 	<div class="col-md-6 pr-1">
	                      <div class="form-group">
	                        <label>Select A Subject</label>
	                        <div >
	                        <select class="form-control" name="subject_code">
	                        	<option >--select a subject--</option>
	                        	<c:forEach items = "${subjects}" var="sub">
	                        	<option value="<c:out value="${sub.getId()}"/>"><c:out value="${sub.getName()} - Rs. ${sub.getFee()}.00"/></option>
	                        	</c:forEach>
	                        </select>
	                        </div>
	                      </div>
                    	</div>
						</div>

						<div class="row">
	                 	<div class="col-md-4 pr-1">
	                      <div class="form-group">
	                        <label>Batch Starting Date</label>
	                        <input type="date" class="form-control" name="batch_starting_date">
	                      </div>
                    	</div>

	                 	<div class="col-md-4 pr-1">
	                      <div class="form-group">
	                        <label>Arrival Timing</label>
	                        <input type="time" class="form-control" placeholder="Batch Starting Time" name="arrival_timing">
	                      </div>
                    	</div>

	                 	<div class="col-md-4 pr-1">
	                      <div class="form-group">
	                        <label>Departure Timing</label>
	                        <input type="time" class="form-control" placeholder="Batch Starting Time" name="departure_timing">
	                      </div>
                    	</div>
	                 	</div>
	                 	
                    	<div class="row">	
                    		<div class="update ml-auto mr-auto">
                    			<input type="submit" class="btn btn-success btn-outline-success btn-round btn-wd " value = "Add">
                    		</div>
                    	</div>
	       	  	  	 </form>
       	  	  	 </div>
       	  	 </div>
       	  </div>

       	
<!-- 			*********						Book added -->
<!-- 			*********						Subjects Records -->

	      <div class="col-md-5 pr-1" >
       	  	 <div class="card card-user">
              
              <div class="card-header">
                <h4 class="card-title"> Subjects Records</h4>
              </div>
              
              <div class="card-body">
              <div class="table-responsive">
                  <table class="table" id="display">
                    <thead class="text-primary">
                      <th>
                         Subject Name 
                      </th>
                      <th class="text-right">
                         Course Fee
                      </th>
                    </thead>
<!-- table body -->                    
                    <tbody>
				<c:forEach items="${subjects}" var="data">
                      <tr>
                        <td>
								<c:out value="${data.getName()}"></c:out>
                        </td>
                        <td class="text-right" >
								<c:out value=" Rs. ${data.getFee()}.00"/>
                        </td>
                      </tr>
                </c:forEach>
              
                    </tbody>
                  </table>
	            </div>
              </div>
            </div>
          </div>
 

<!-- 			*********						Subject Record end-->
<!-- 			*********						Books Record table -->

<div class="col-md-5" >
            <div class="card">
              <div class="card-header">
                <h4 class="card-title"> Batches Records</h4>
              </div>
              <div class="card-body">
                  <table class="table" id="display1">
                    <thead class="text-primary">
                      <th>
                         Batch Name 
                      </th>
                      <th >
                         Batch Timing
                      </th>
                    </thead>
<!-- table body -->                    
                    <tbody>
				<c:forEach items="${allBatch}" var="data">
                      <tr>
                        <td >
								<c:out value="${data.getBatchName()}"></c:out>
                        </td>
                        <td >
								<c:out value="${data.getArrival_timing()} - ${data.getDeparture_timing()}"></c:out>
                        </td>
                      </tr>
                </c:forEach>
                    </tbody>
                  </table>
              </div>
            </div>
          </div>
</div>
</div>
	
<!-- 			********* batch record End -->
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

  <script src="js/core/popper.min.js"></script>
  <script src="js/core/bootstrap.min.js"></script>
<!--   <script src="plugins/perfect-scrollbar.jquery.min.js"></script> -->
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
