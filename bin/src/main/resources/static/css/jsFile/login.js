
function pass104(){
	$("#p104").hide();
	if(($("#password").val()).length==0){
		$("#p103").hide();
		$('#p102').attr('disabled', 'disabled');
		return false;
	}
	
	else if(($("#password").val()).length>=8){
		
		$("#p104").hide();
			$("#p103").hide();
			$('#p102').removeAttr('disabled');
			return true;
			
		}
		else{
			
			$("#p103").show();
			$('#p102').attr('disabled', 'disabled');
			return false
			}
}


function userId(){
	
	
	$("#p104").hide();
	$("p101").hide();
	emailFilter2=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	emailFilter1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;
	// email-
	
	if(($("#username").val()).length==0){
		$("#p101").hide();
		$('#p102').attr('disabled', 'disabled');
		return false;
	}
	
	else if(((emailFilter1).test($("#username").val()) && (emailFilter2).test($("#username").val()))){
		$("#p101").hide();
		$('#p102').removeAttr('disabled');
		return true
	}
	else{
			$("#p101").show();
			$('#p102').attr('disabled', 'disabled');
			return false;
		}	
}
	
	
	function togglePass(){
		  const password = document.getElementById('password');
		  if (password.type === 'password') {
		    password.type = 'text';
		  } else {
		    password.type = 'password';
		  }
		};
	

//
// $(function() {
// $('#form101').bind('submit', function() {
// uname1= $("#uname").val();
// password=$("#password").val();
// $.ajax({
// type : 'GET', // define the type of HTTP verb we want to use (POST for our
// form)
// url : 'http://localhost:8080/pal/LoginUser', // the url where we want to POST
// data : "uname="+uname1+"&password="+password , // our data object
// dataType : 'json', // what type of data do we expect back from the server
// contentType : "application/json; charset=utf-8",
// // encode : true,
// cache : false,
// success : function(data) {
//				        	
// console.log("User Logged in Successfully");
//				            
// },
// error : function(request, status, error) {
// if(status==400){
// setTimeout(() => {
// $("#p104").show();
// }, 5000);
// }
// }
//					
// });
//					
// });
// });



//  $('#RememberMe').attr('checked', true); 
 
$(function() {
	$('#form101').bind('submit', function() {
		event.preventDefault();
		var rem;
		if($("input[name=remember-me]:checked").length>0){
			rem="on";
		}else{
			rem="off";
		}
		data1={ 
				username	:$("#username").val(),
				password	:$("#password").val(),
				rememberMe  :rem	
		}
		$.ajax({
	      url: "LoginUser",
	      type: 'POST',
	      data : data1,
	      success: function(){
	        $(location).attr('href',"Home");
//	    	  $.ajax({
//	    	        type        : 'Get', // define the type of HTTP verb we want to use (POST for our form)
//	    	        url         : 'Home', // the url where we want to POST
////	    	        dataType    : 'json', // what type of data do we expect back from the server
////	    	        contentType : "application/json; charset=utf-8",
////	    	        encode      : true,
//	    	        cache		: false,
//	    	        success :function(data){
//	    	        	
//	    	        	},
//	    	        error: function(error){
//	    	        	console.log(error);
//	    	        }
//	    	        	
//	    	        });
	      },
	    error: function(){
	    	
	    	
	    		$("#p104").show(); 
	    		setTimeout(() => {
					$("#p104").hide();
				}, 3000);
	    		$("#uname").val("");
	    		$("#password").val("");
	    		$("#rememberMe").val("off");
	    		$("#p102").attr('disabled', 'disabled');
	    	
	    }
	    });
	   	
	});
	});