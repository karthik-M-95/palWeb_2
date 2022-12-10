function nameValidate(){
	$("#p201").hide();
	$("#p202").hide();
	$("#p204").hide();
	$("#p203").hide();$("#p206").hide();$("#p207").hide();$("#p208").hide();$("#p209").hide();
	
	
	// regex for name
	nameFilter1= /^([A-Za-z]*)+$/;
	name=$('#uname11').val();
	
	if(($("#uname11").val()).length==0){
		$("#p201").hide();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
	}
	if((name.length>2 &&(nameFilter1).test(name))){
		
		$("#p201").hide();
		$('#signbtn21').removeAttr('disabled');
		return true;
	}
	else {
		$("#p201").show();
		$('#signbtn21').attr('disabled', 'disabled');
		return false
	}

}


function emailFilter(){
	$("#p202").hide();
	emailFilter2=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	emailFilter1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;
	//email-
	
	
	if(($("#email11").val()).length==0){
		$("#p202").hide();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
	}
	
	else if(((emailFilter1).test($("#email11").val()) && (emailFilter2).test($("#email11").val()))){
		$("#p202").hide();
		$('#signbtn21').removeAttr('disabled');
		return true
	}
	else{
			$("#p202").show();
			$('#signbtn21').attr('disabled', 'disabled');
			return false;
		}	
}


function passwordCheck(){
	
	var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	var regDigit=/^(?=.*[0-9]){1,}/ ;
	var regLower=/^(?=.*[a-z])/;
	var regUpper= /^(?=.*[A-Z])/;
	var regSpec=/^(?=.*[!@#$%^&*])/;
	$("#p203").hide();$("#p206").hide();$("#p207").hide();$("#p208").hide();$("#p209").hide();
//	console.log(regDigit.test($("#psw11").val()));
//	console.log(regLower.test($("#psw11").val()));
//	console.log(regSpec.test($("#psw11").val()));
//	console.log(regularExpression.test($("#psw11").val()));
//	console.log(regUpper.test($("#psw11").val()) );
	
	if(($("#psw11").val()).length==0){
		$("#p211").hide();
		$("#p203").hide();
		$("#p206").hide();
		$("#p207").hide();
		$("#p208").hide();
		$("#p209").hide();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
	}
	
	else if(($("#psw11").val()).length>=8){
		
			
			if((regDigit.test($("#psw11").val()))){
				
				if((regLower.test($("#psw11").val()))){
					
					if((regUpper.test($("#psw11").val()))){
						if((regSpec.test($("#psw11").val()))){
							
							if( (($("#psw11").val()).length>=8) && (($("#psw11").val()).length<=15)){
								$("#p203").hide();
								$("#p206").hide();
								$("#p207").hide();
								$("#p208").hide();
								$("#p209").hide();
								$("#p211").hide();
								$('#signbtn21').removeAttr('disabled');
								return true;
								
								
							}
							else{
								$("#p211").show();
								$('#signbtn21').attr('disabled', 'disabled');
								return false;
								
							}
		
							
						}
						else{
							
							$("#p209").show();
							$('#signbtn21').attr('disabled', 'disabled');
							return false;
						}
					}
					else{
						$("#p208").show();
						$('#signbtn21').attr('disabled', 'disabled');
						return false;
						
					}
				}
				else{
					$("#p207").show();
					$('#signbtn21').attr('disabled', 'disabled');
					return false;
				}
				
			}
			else{
				$("#p206").show();
				$('#signbtn21').attr('disabled', 'disabled');
				return false;
			}
			
		}else{
			$("#p203").show();
			$('#signbtn21').attr('disabled', 'disabled');
			return false;
		}
		
//		if(!(((($("#psw11").val()).length)>=8) && regDigit.test($("#psw11").val()) && regLower.test($("#psw11").val()) && regUpper.test($("#psw11").val()) 
//				 && regSpec.test($("#psw11").val()) && regularExpression.test($("#psw11").val())  )){
			

		/*	/^[^6-9]\d{9}$/" +
			"if(email.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/))
			
			var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
			 (/^
				        (?=.*\d)                //should contain at least one digit
				        (?=.*[a-z])             //should contain at least one lower case
				        (?=.*[A-Z])             //should contain at least one upper case
				        [a-zA-Z0-9]{8,} 

			function validatePassword() {
			    var p = document.getElementById('newPassword').value,
			        errors = [];
			    if (p.length < 8) {
			        errors.push("Your password must be at least 8 characters"); 
			    }
			    if (p.search(/[a-z]/i) < 0) {
			        errors.push("Your password must contain at least one letter.");
			    }
			    if (p.search(/[0-9]/) < 0) {
			        errors.push("Your password must contain at least one digit."); 
			    }
			    if (errors.length > 0) {
			        alert(errors.join("\n"));
			        return false;
			    }
			    return true;
			}*/
				
		}	
		

function dobCheck(){
//	console.log($("#dob").val())
	var dateformat = /^(\d{4})[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;   // (0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	

 if(dateformat.test($("#dob").val())){
		  var datearr;
		  var date1=$("#dob").val().split("-");
		  var date2=$("#dob").val().split("/");

		if (date1.length > 0) {
			datearr = date1;
		} else {
			datearr = date2;
		}
//		  console.log($(typeof($("#dob").val())))
		  var dd = parseInt(datearr[2]);
		  var mm  = parseInt(datearr[1]);
		  var yy = parseInt(datearr[0]);
		  
		  if(mm==1 || mm==3 || mm==5 ||mm==7 || mm==8 || mm==10 || mm==12){
			  if(dd<=31){
					$("#p210").hide();
					$('#signbtn21').removeAttr('disabled');
					return true;			
			  }
			  else{
				  $("#p210").show();
					$('#signbtn21').attr('disabled', 'disabled');
					return false
			  }
		  }
		  else if(mm==4 || mm==6 || mm==9 ||mm==11 ){
			  if(dd<=30){
					$("#p210").hide();
					$('#signbtn21').removeAttr('disabled');
					return true;			
			  }
			  else{
				  $("#p210").show();
					$('#signbtn21').attr('disabled', 'disabled');
					return false;
			  }
		  }
		  else if(mm==2){
			   if((yy % 4 ==0 || yy % 100==0) ){
				   if(dd<=29){
					   $("#p210").hide();
						$('#signbtn21').removeAttr('disabled');
						return true;
				   }
				   else{
					   $("#p210").show();
						$('#signbtn21').attr('disabled', 'disabled');
						return false;
				   }
			   }
			   else{
				   if(dd<=28){
					   
					   $("#p210").hide();
						$('#signbtn21').removeAttr('disabled');
						return true;
				   }else{
					   
					   $("#p210").show();
						$('#signbtn21').attr('disabled', 'disabled');
						return false;
				   }
			   }
			  
		  }
		  
	  }else{
		  $("#p210").show();
			$('#signbtn21').attr('disabled', 'disabled');
			return false;
	  }
	
}


function passwordReCheck(){
	
	$("#p204").hide();
	
	if(($("#psw11").val()).length==0){
		$("#p204").hide();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
	}
	else if(($("#psw11").val()).length>=8){
	if((($("#psw11").val())===($("#psw-repeat11").val()))){
		
		$("#p204").hide();
		$('#signbtn21').removeAttr('disabled');
		return true;
	}
	else{
		
		$("#p204").show();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
		
	}	
	}
	else{
		$("#p203").show();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;}
}


function mobileCheck(){
	mobFilter= /^([0-9]{10})+$/;
	$("#p205").hide();
	
	if(($("#mob11").val()).length==0){
		$("#p205").hide();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
	}
	else if((($("#mob11").val()).length==10 ) && (mobFilter.test($("#mob11").val()))){
		
		$("#p205").hide();
		$('#signbtn21').removeAttr('disabled');
		return true;
	}else{
		
		$("#p205").show();
		$('#signbtn21').attr('disabled', 'disabled');
		return false;
		
		
	}
}


function validateForm(){
		
	var name2=nameValidate();
	var email2=emailFilter();
	var pass=passwordCheck();
	var pass1=passwordReCheck();
	var mob2=mobileCheck();
	var dob=dobCheck();
	
	if(name2 && email2 && pass && pass1 && dob && mob2){
		return true;
	}
	else{
		return false;
	}
	return true;
}


function openModal(){
	setTimeout(function() {
        window.location.reload();
   },100)
}

$(function() {
	$('#cpa-form').bind('submit', function() {
			

//function register1045(){
		if(validateForm){
			event.preventDefault();
			var formData = {
			        'userName'              : $('#uname11').val(),
			        'userEmail'             : $("#email11").val(),
			        'userPassword'    		: $("#psw11").val(),
			        'mobileNo'				: $("#mob11").val(),
			        'dateOfBirth'			: $("#dob").val()
			        
			    };
			var data1=JSON.stringify(formData);
			$.ajax({
		        type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
		        url         : 'user/addNewUser', // the url where we want to POST
		        data        : data1, // our data object
		        dataType    : 'json', // what type of data do we expect back from the server
		        contentType : "application/json; charset=utf-8",
//		        encode      : true,
		        cache		: false,
		        success : function(data) {
		        	var uname=data.userName;
		        	
		        	$('#myModal').modal('show');
		            return false;
		        	
		            
		        },
		        error : function(request, status, error) {
//		        	$('#modalForm2').modal('show'); 
		        	console.log("failure");
		        	
		        }
		    })
		    
			
//		}
}
		
	});
});

