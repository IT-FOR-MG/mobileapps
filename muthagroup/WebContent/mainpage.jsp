<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.muthagroup.vo.MuthaGroupVO"%>
<html lang="en">
<head>
  <title>Mutha Group of Engineering Satara</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css" >
  <link rel="stylesheet" href="css/bootstrap-datepicker.css" >
  <link rel="stylesheet" href="css/bootstrap-iso.css" />
  <link rel="stylesheet" href="css/font-awesome.min.css" />
  <link rel="stylesheet" href="css/bootstrap-datepicker3.css"/>
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript" src="js/formden.js"></script>
  <script>

  $(function() { // when the DOM is ready...
      //  Move the window's scrollTop to the offset position of #now
      $(window).scrollTop($('#DailyReport').offset().top);
  });


	$(document).ready(function(){
		var date_input=$('input[name="date"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'yyyy-mm-dd',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
	
	$(document).on("click", ".modal-link", function () {
     var myBookId = $(this).data('id');
     document.getElementById('lbl').innerHTML =myBookId;
     $(".loginmodal-container #bookId").val( myBookId );
     // As pointed out in comments, 
     // it is superfluous to have to manually call the modal.
     // $('#addBookDialog').modal('show');
});
	
</script>

 

  <style>
  .bootstrap-iso 
.formden_header h2, 
.bootstrap-iso .formden_header p, 
.bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}
.bootstrap-iso form button, 
.bootstrap-iso form button:hover{color: white !important;} 
.asteriskField{color: red;}
  
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 1px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    @import url(http://fonts.googleapis.com/css?family=Roboto);

/****** LOGIN MODAL ******/
.loginmodal-container {
  padding: 30px;
  max-width: 350px;
  width: 100% !important;
  background-color: #F7F7F7;
  margin: 0 auto;
  border-radius: 2px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
  font-family: roboto;
}

.reportmodal-container {
  padding: 30px;
  max-width: 350px;
  width: 100% !important;
  background-color: #F7F7F7;
  margin: 0 auto;
  border-radius: 2px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
  font-family: roboto;
}

.loginmodal-container h1 {
  text-align: center;
  font-size: 1.8em;
  font-family: roboto;
}

.loginmodal-container input[type=submit] {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;

}

.loginmodal-container input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 100%;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9;
  border-top: 1px solid #c0c0c0;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.loginmodal-container input[type=text]:hover, input[type=password]:hover {
  border: 1px solid #b9b9b9;
  border-top: 1px solid #a0a0a0;
  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.loginmodal {
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
/* border-radius: 3px; */
/* -webkit-user-select: none;
  user-select: none; */
}

.loginmodal-submit {
  /* border: 1px solid #3079ed; */
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #4d90fe;
  padding: 17px 0px;
  font-family: roboto;
  font-size: 14px;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}


.loginmodal-submit:hover {
  /* border: 1px solid #2f5bb7; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #357ae8;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.loginmodal-container a {
  text-decoration: none;
  color: #666;
  font-weight: 400;
  text-align: center;
  display: inline-block;
  opacity: 0.6;
  transition: opacity ease 0.5s;
} 

.reportmodal-container {
  text-align: center;
  height: 600px;
  font-size: 16px;
  max-width: 700px;
  width: 100%;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9;
  border-top: 1px solid #c0c0c0;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.login-help{
  font-size: 12px;
}
  </style>
</head>
<body>
<%
String username=null;
if ((username=(String)session.getAttribute("user")) == null) 
{
	out.print("Please login first");  
    request.getRequestDispatcher("index.jsp").include(request, response);  
}
else
{
%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img src="images/mutha.jpg" class="img-circle" alt="Mutha logo" width=50 height=30> </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Daily Vendor Stock Status Report</a></li>
        <!-- <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a  data-toggle="modal" href="#loginModal"><span class="glyphicon glyphicon-log-out"></span><b> <%=username%></b> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-12 text-left"> 
    <div class="page-header" align="center">
     <!--  <h1>Welcome to Mutha Group of Industries</h1>
      <blockquote class="blockquote-reverse">
      <p>Maximum production is our Target, Best quality is our Aim.</p>
      </blockquote>
      <hr> -->
      
      <a href="#Report" class="modal-link" data-id="Daily Report" data-toggle="modal" >Get Daily Report</a><!--  | <a href=#Report class="modal-link"  data-toggle="modal" data-id="Monthly Summary Report" >Get Monthly Summary </a>
      | <a href=#Report class="modal-link" data-id="Daily Supervisor's Report"  data-toggle="modal">Daily Supervisor's Report</a> -->
      </div>
      <div id="DailyReport" >		
		         <label>Date:${date}</label> 
		        
		         <button onclick="myFunction('DailyReport')"  class="btn btn-default btn-sm" ><span class="glyphicon glyphicon-print"></span> Print</button>

<script>
function myFunction(divName) {
	var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}
</script>

		          	         
                 <table class="table table-bordered" >         
                 <tr><th>Items</th><th>Monthly Schedule</th><th>Dispatched</th><th>Vendor</th><th>Total ERP Stock</th><th>WIP</th><th>Packed</th><th>For Packing</th><th>For Inspection</th><th>Total RFD</th><th>Casting Defect</th><th>Machining Defect</th><th>Surface Finishing</th><th>Milling</th><th>Drilling</th><th>VMC1</th><th>VMC2</th></tr>
                 <tr><td>ROF 125 CC</td><td>${list.get(0).get(0)}</td><td>${dislist.get(0)}</td><td>MEPL H25</td><td>${stocklist.get(0)}</td><td>${list.get(1).get(3)+list.get(1).get(4)+list.get(1).get(5)+list.get(1).get(6)+list.get(1).get(7)+list.get(1).get(8)+list.get(1).get(9)}</td><td>${list.get(1).get(0)}</td><td>${list.get(1).get(1)}</td><td>${list.get(1).get(2)}</td><td>${list.get(1).get(0)+list.get(1).get(1)+list.get(1).get(2)}</td><td>${list.get(1).get(3)}</td><td>${list.get(1).get(4)}</td><td>${list.get(1).get(5)}</td><td>${list.get(1).get(6)}</td><td>${list.get(1).get(7)}</td><td>${list.get(1).get(8)}</td><td>${list.get(1).get(9)}</td></tr>
                 <tr><td>ROF 100 CC</td><td>${list.get(0).get(1)}</td><td>${dislist.get(1)}</td><td>MEPL H25</td><td>${stocklist.get(1)}</td><td>${list.get(2).get(3)+list.get(2).get(4)+list.get(2).get(5)+list.get(2).get(6)+list.get(2).get(7)+list.get(2).get(8)+list.get(2).get(9)}</td><td>${list.get(2).get(0)}</td><td>${list.get(2).get(1)}</td><td>${list.get(2).get(2)}</td><td>${list.get(2).get(0)+list.get(2).get(1)+list.get(2).get(2)}</td><td>${list.get(2).get(3)}</td><td>${list.get(2).get(4)}</td><td>${list.get(2).get(5)}</td><td>${list.get(2).get(6)}</td><td>${list.get(2).get(7)}</td><td>${list.get(2).get(8)}</td><td>${list.get(2).get(9)}</td></tr>
                 <tr><td>B 104 D</td><td>${list.get(0).get(2)}</td><td>${dislist.get(2)}</td><td>MEPL H25</td><td>${stocklist.get(2)}</td><td>${list.get(3).get(3)+list.get(3).get(4)+list.get(3).get(5)+list.get(3).get(6)+list.get(3).get(7)+list.get(3).get(8)+list.get(3).get(9)}</td><td>${list.get(3).get(0)}</td><td>${list.get(3).get(1)}</td><td>${list.get(3).get(2)}</td><td>${list.get(3).get(0)+list.get(3).get(1)+list.get(3).get(2)}</td><td>${list.get(3).get(3)}</td><td>${list.get(3).get(4)}</td><td>${list.get(3).get(5)}</td><td>${list.get(3).get(6)}</td><td>${list.get(3).get(7)}</td><td>${list.get(3).get(8)}</td><td>${list.get(3).get(9)}</td></tr>
                 <tr><td>TVS 74 CC</td><td>${list.get(0).get(3)}</td><td>${dislist.get(3)}</td><td>MEPL H25</td><td>${stocklist.get(3)}</td><td>${list.get(4).get(3)+list.get(4).get(4)+list.get(4).get(5)+list.get(4).get(6)+list.get(4).get(7)+list.get(4).get(8)+list.get(4).get(9)}</td><td>${list.get(4).get(0)}</td><td>${list.get(4).get(1)}</td><td>${list.get(4).get(2)}</td><td>${list.get(4).get(0)+list.get(4).get(1)+list.get(4).get(2)}</td><td>${list.get(4).get(3)}</td><td>${list.get(4).get(4)}</td><td>${list.get(4).get(5)}</td><td>${list.get(4).get(6)}</td><td>${list.get(4).get(7)}</td><td>${list.get(4).get(8)}</td><td>${list.get(4).get(9)}</td></tr>
                 <tr><td>KubotaHead BS 3</td><td>${list.get(0).get(4)}</td><td>${dislist.get(4)}</td><td>MEPL H21</td><td>${stocklist.get(4)}</td><td>${list.get(5).get(3)+list.get(5).get(4)+list.get(5).get(5)+list.get(5).get(6)+list.get(5).get(7)+list.get(5).get(8)+list.get(5).get(9)}</td><td>${list.get(5).get(0)}</td><td>${list.get(5).get(1)}</td><td>${list.get(5).get(2)}</td><td>${list.get(5).get(0)+list.get(5).get(1)+list.get(5).get(2)}</td><td>${list.get(5).get(3)}</td><td>${list.get(5).get(4)}</td><td>${list.get(5).get(5)}</td><td>${list.get(5).get(6)}</td><td>${list.get(5).get(7)}</td><td>${list.get(5).get(8)}</td><td>${list.get(5).get(9)}</td></tr>
                 <tr><td>KubotaHead BS 4</td><td>${list.get(0).get(5)}</td><td>${dislist.get(5)}</td><td>MEPL H21</td><td>${stocklist.get(5)}</td><td>${list.get(6).get(3)+list.get(6).get(4)+list.get(6).get(5)+list.get(6).get(6)+list.get(6).get(7)+list.get(6).get(8)+list.get(6).get(9)}</td><td>${list.get(6).get(0)}</td><td>${list.get(6).get(1)}</td><td>${list.get(6).get(2)}</td><td>${list.get(6).get(0)+list.get(6).get(1)+list.get(6).get(2)}</td><td>${list.get(6).get(3)}</td><td>${list.get(6).get(4)}</td><td>${list.get(6).get(5)}</td><td>${list.get(6).get(6)}</td><td>${list.get(6).get(7)}</td><td>${list.get(6).get(8)}</td><td>${list.get(6).get(9)}</td></tr>
                 <tr><td>TVS 4 S</td><td>${list.get(0).get(6)}</td><td>${dislist.get(6)}</td><td>MEPL H21</td><td>${stocklist.get(6)}</td><td>${list.get(7).get(3)+list.get(7).get(4)+list.get(7).get(5)+list.get(7).get(6)+list.get(7).get(7)+list.get(7).get(8)+list.get(7).get(9)}</td><td>${list.get(7).get(0)}</td><td>${list.get(7).get(1)}</td><td>${list.get(7).get(2)}</td><td>${list.get(7).get(0)+list.get(7).get(1)+list.get(7).get(2)}</td><td>${list.get(7).get(3)}</td><td>${list.get(7).get(4)}</td><td>${list.get(7).get(5)}</td><td>${list.get(7).get(6)}</td><td>${list.get(7).get(7)}</td><td>${list.get(7).get(8)}</td><td>${list.get(7).get(9)}</td></tr>
                 <tr><td>TVS CITY</td><td>${list.get(0).get(7)}</td><td>${dislist.get(7)}</td><td>MEPL H21</td><td>${stocklist.get(7)}</td><td>${list.get(8).get(3)+list.get(8).get(4)+list.get(8).get(5)+list.get(8).get(6)+list.get(8).get(7)+list.get(8).get(8)+list.get(8).get(9)}</td><td>${list.get(8).get(0)}</td><td>${list.get(8).get(1)}</td><td>${list.get(8).get(2)}</td><td>${list.get(8).get(0)+list.get(8).get(1)+list.get(8).get(2)}</td><td>${list.get(8).get(3)}</td><td>${list.get(8).get(4)}</td><td>${list.get(8).get(5)}</td><td>${list.get(8).get(6)}</td><td>${list.get(8).get(7)}</td><td>${list.get(8).get(8)}</td><td>${list.get(8).get(9)}</td></tr>
                 <tr><td>TVS SPORT</td><td>${list.get(0).get(8)}</td><td>${dislist.get(8)}</td><td>MEPL H21</td><td>${stocklist.get(8)}</td><td>${list.get(9).get(3)+list.get(9).get(4)+list.get(9).get(5)+list.get(9).get(6)+list.get(9).get(7)+list.get(9).get(8)+list.get(9).get(9)}</td><td>${list.get(9).get(0)}</td><td>${list.get(9).get(1)}</td><td>${list.get(9).get(2)}</td><td>${list.get(9).get(0)+list.get(9).get(1)+list.get(9).get(2)}</td><td>${list.get(9).get(3)}</td><td>${list.get(9).get(4)}</td><td>${list.get(9).get(5)}</td><td>${list.get(9).get(6)}</td><td>${list.get(9).get(7)}</td><td>${list.get(9).get(8)}</td><td>${list.get(9).get(9)}</td></tr>
                 </table>     
	  </div>
    </div>
  </div>
</div>
<div class="modal fade active" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Are you want to log out</h1><br>
	               <form class="form-inline" action="Logout" method="post">
	                <input type=submit  class="btn btn-info btn-lg" type="submit" value="Log out"  autofocus >
	                 </form>      		
				</div>
			</div>
		  </div>
        <div class="modal fade active" id="Report" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	   <div class="modal-dialog">
		     <div class="loginmodal-container">
				<h1> <label id="lbl">test</label> </h1><br>
	             <form class="form-inline" action="DailyReport" method="post">
	              <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text" required />
	              <input type=submit  class="btn btn-info btn-lg" type="submit" value="Get Report"  autofocus  >
	            </form>
			 </div>   		
		   </div>
		</div>
	   
	
<%
}
%>
</body>
</html>
