$(document).ready(function() {
	
	$.ajax({
        type        : 'Get', // define the type of HTTP verb we want to use (POST for our form)
        url         : 'getProfile', // the url where we want to POST
//      data        : data1, // our data object
        dataType    : 'json', // what type of data do we expect back from the server
        contentType : "application/json; charset=utf-8",
//        encode      : true,
        cache		: false,
        success :function(data){
        	        	
        	var date=data.dateOfBirth;
        	var date1=new Date(date);
        	let formatted_date = date1.getDate() + "-" + (date1.getMonth() + 1) + "-" + date1.getFullYear()
        
//        
//        	var record="";
//        	$(data.user).each(function(index,value){
//        		record="<tr><th>Name:</th><td>"+data.userName+"</td></tr>"+
//        		"<tr><th>Email:</th><td>"+data.userEmail+"</td></tr>"+"<tr><th>D.O.B:</th><td>"+formatted_date+"</td></tr>"+
//        		"<tr><th>Phone</th><td>"+(data.mobileNo)+"</td></tr>"
//        		$("#pro352").append(record);
//        	});
        	
        	$("#pro352").append(
       "<tr><th>Name:</th><td>"+data.userName+"</td></tr>"+
       "<tr><th>Email:</th><td>"+data.userEmail+"</td></tr>"+
       "<tr><th>D.O.B:</th><td>"+formatted_date+"</td></tr>"+
       "<tr><th>Phone</th><td>"+(data.mobileNo)+"</td></tr>")
//       document.getElementById("pro352").updateRow(2).innerHTML = '<td>'+data.userEmail+'</td>';
            
     
        	
        	},
        error: function(error){
        	console.log(error);
        }
        	
        });
	
	
});
	
