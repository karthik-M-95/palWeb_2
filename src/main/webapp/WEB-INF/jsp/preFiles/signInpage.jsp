<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="css/js/jquery-3.5.0.js"> </script>
<script type="text/javascript" src="css/js/bootstrap.min.js"> </script>
<script type="text/javascript" src="css/jsFile/signup201.js"> </script>
<link rel="stylesheet" type="text/css" href="css/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/css/bootstrap.min.css" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Pal SignIn </title>
<style>


.navbar{
border-bottom: 0px solid #ffffff;
margin-bottom: 0px;
}
.navbar {
    border-radius: 0px;
}

input[type=text], input[type=password], input[type=number],[type=date] {
  width: 100%;
  padding: 8px;
  margin: 5px 0 11px 0px;
  display: inline-block;
  border: none;
  background: #f1f1f1;
  height:25px;
}



input[type=text]:focus, input[type=password]:focus,input[type=number]:focus,[type=date]:focus {
  background-color: white;
  outline: none;
  color:black;
   transform:scale(1.1,1.1);
}

input[type="date"]::-webkit-calendar-picker-indicator {
    color: #2c3e50;
}

/* A few custom styles for date inputs */
input[type="date"] {
    appearance: none;
    -webkit-appearance: none;
    color: #95a5a6;
    font-family: "Helvetica", arial, sans-serif;
    font-size: 18px;
    border:1px solid #ecf0f1;
    background:#ecf0f1;
    padding:5px;
    display: inline-block !important;
    visibility: visible !important;
}

input[type="date"], focus {
    color: #95a5a6;
    box-shadow: none;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 7px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.modal-body {
  max-height: 800px; 
}

.modal{
  overflow-y: auto;
}


button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 10px;
  background-color: #f94336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: center;
  width: 50%;
}

.clearfix::after {
  content: "";
  clear: both;
  display: table;
  padding: 20px 0px 10px 20px;
}

.clearfix {
  padding: 20px 10px 20px 10px;
}

 .body1{
  width: 100%;
   height: auto;	
    position: absolute;
    background-image: url("css/img/rover224.jpg");
    background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  justify-content: center;
 }
 .form-group{
margin-bottom:5px;
}
lable{
font-style:bold;
}
 
 
 .sdiv{
 background-color:rgba(173, 216, 230,0.5);
 opacity:0.9;
 height:100%;
 width:auto;
 border-radius: 25px;
 justify-content: center;
 position:relative;
 }

.modal.fade.in{
top:60%;
padding: 0px 25px 0px 25px;
}
.modal{
bottom:auto;
width:auto;
right:auto;
left:750px;
height:auto;
border-radius:20px;
background-color:rgb(255 245 169);
}

.modal-content{
border-radius:20px;
background-color:rgba(102, 255, 217,0.8)
}

 .forms{
 margin: 25px 34px 0px 0px;
 width:80%;
 }


</style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">Pal</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="home">Home</a></li>
      <li ><a href="AboutUs">About us</a></li>
      <li><a href="ContactUs">Contact us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li class="active"><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li ><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
 

  
  <div class="container-fluid body1">
  
  	
  	
  	
<div class="row">
<div class="col-md-offset-5 col-md-4">
<div class="container">
   <!-- Modal -->
  <div class="modal fade" id="myModal" style="padding-right:25px;" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">	
        <div class="modal-header">
          <button type="button" class="close" onclick="openModal();" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Confirmation Message</script></h4>
        </div>
        <div class="modal-body">
        <form id="modalForm" action="Login" method="get">
          <p>Your Registration was successful.<br>
          Please click OK to Login</p>
          </form>
        </div>
        <div class="modal-footer" style="background-color:rgba(102, 255, 217,0.8)">
         <a href="Login"> <button type="submit" class="btn btn-primary" >OK</button></a>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>
   
  <div class="row">
  	
  	<div class="col-md-offset-4 col-md-5 ">
  	
  	
  	<form class="forms sdiv" role="form" id="cpa-form"  onsubmit="return validateForm()" method="post">
  <div class="container-fluid">
    <div class="form-group">
      <h1 style="text-align:center; color:black;font-style: bold;"> Register </h1>
      
      <br>
      
      </div>
      
      
      <div class="form-group has-success has-feedback">
      <label class="control-label" for="uname11" ><b>First Name</b></label>
      <input type="text" id="uname11" class="form-control" placeholder="Enter Name" name="uname11" title="Name should be more than 6 character" required onkeyup="nameValidate();">
      
      <p id="p201" style="color:red; display: none;" >Enter a valid username</p>
    <!--    <span id="gly-1" class="glyphicon glyphicon-ok form-control-feedback" ></span>
      <span id="gly-2" class="glyphicon glyphicon-remove form-control-feedback"></span> -->
      </div>
      
      <div class="form-group">
      <label for="email11"  ><b>Email</b></label>
      <input type="text" id="email11" class="form-control" placeholder="Enter Email" name="email11" required onkeyup="emailFilter();">
       <p id="p202" style="color:red; display: none;" >Enter a valid email</p>
		</div>

	<div class="form-group">
      <label for="psw11"  ><b>Password</b></label>
      <input type="password" id="psw11" max=15 class="form-control" placeholder="Enter Password" name="psw11" required 
      title="Password should contain a digit,lower case, upper case and special character" onkeyup="passwordCheck();">
       <p id="p203" style="color:red; display: none;">Your password length should be of 8 or more characters <br/> <span> with a digit,lower case, upper case and special character</span></p>
		<p id="p206" style="color:red; display: none;">Your password must contain at least one digit</p>
		<p id="p207" style="color:red; display: none;">Your password must contain at least one Lower case</p>
		<p id="p208" style="color:red; display: none;">Your password must contain at least one Upper case</p>
		<p id="p209" style="color:red; display: none;">Your password must contain at least one Special character</p>
		<p id="p211" style="color:red; display: none;">Your password length must not be greater than 15</p>	
		
	</div>
	
	<div class="form-group">
      <label for="psw-repeat11"  ><b>Confirm Password</b></label>
      <input type="password" id="psw-repeat11" class="form-control" placeholder="Confirm Password" name="psw-repeat11" required onkeyup="passwordReCheck();">
       <p id="p204" style="color:red; display: none;">Password not matched</p>
     </div>
     

  
       <div class="form-group">
       <label for="dob">DOB:</label>
       <input type="date" id="dob" name="dob" class="form-control" placeholder="Date of birth" required="required" onkeyup="dobCheck();"  >
      <p id="p210" style="color:red; display: none;">Enter a valid Date</p>
      </div>	 
      
      <div class="form-group">
      <label for="mob11"  id="mob1" ><b>Mobile No. </b></label>
      <input type="number" id="mob11" maxlength="10"  placeholder="Enter Mobile Number" class="form-control" name="mob1" required onkeyup="mobileCheck();">
       <p id="p205" style="color:red; display: none;" >Enter a valid mobile No.</p>
      </div>
  <!--    <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label>    --> 

      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

		 <button type="reset" style="font-size:24px; background-color:#4CAF50;padding: 0px; margin: 0px; width: 10%;"> <i class="fa fa-refresh"></i></button>
		 
		 

      <div class="clearfix">
   
     
     <!--     <input   ><i style="font-size:24px" class="fa">&#xf021;</i></input>   -->
        <button class="btn btn-primary" disabled="disabled" id="signbtn21" type="submit"  class="signupbtn">Sign Up</button>
         <a href="home" style="color:white"> <button class="btn btn-warning"  type="button" >Cancel </button></a>
    
      </div>
    </div>
  </form>
  	
  	  
  
  	
  	
  	 </div>
  	 
  
  </div>
</div>


  


</body>
</html>
