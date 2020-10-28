// Window On Load
window.onload = function() {

	showList();	
	
	$("#createAssignment").hide();
	$("#downloadData").hide();
	
	$("#insertData").show();

}

$("#createAssign").click(function(){
	
	$("#downloadData").hide();
	$("#insertData").hide();
	
	$("#createAssignment").show();
	
});


$("#downloadAssign").click(function(){
	
	$("#createAssignment").hide();
	$("#insertData").hide();
	
	$("#downloadData").show();
	
	showDownload();
	
});

// Show List
function showList() {	
	
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/AssignmentListing";

	$.ajax({

		url : service_url,
		type : "post",
		dataType : "json",
		success : function(responseData) {
			var hl = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>" +
					"<th style='width: 20%;' scope='col'>Sr. No.</th>"+
					"<th style='width: 20%;' scope='col'>Questions</th>"+
			"<th style='width: 20%;' scope='col'>Last Date</th>"+
			"<th style='width: 20%;' scope='col'>Update Action</th>"+
			"<th style='width: 20%;' scope='col'>Delete Action</th>";
			for (var i = 0; i < responseData.length; i++) {
				var html = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>";
				
				html += "<th style='width: 20%;' scope='col'><span id='TID"+responseData[i][0]+"'>"+(i+1)+"</span></th>";
				html += "<th style='width: 20%;' scope='col'><textarea class='form-control rounded-0' id='Q"+responseData[i][0]+"'> "+responseData[i][1]+"  </textarea></th>";
				html += "<th style='width: 20%;' scope='col'><input type='text' value='"+responseData[i][2]+"' id='LD"+responseData[i][0]+"' /></th>";								
				html += "<th style='width: 20%;' scope='col'><input type='submit' onclick='update("+responseData[i][0]+")' value='Update' class='btn btn-primary' /></th>";
				html += "<th style='width: 20%;' scope='col'><input type='submit' onclick='deleteRecord("+responseData[i][0]+")' value='Delete' class='btn btn-danger' /></th>";
				
				html += "</tr></thead></table></div></div>";
				hl += html;
			}
			
			hl += "</tr></thead></table></div></div>";
			
			$("#insertData").append(hl);			
		},
		error : function(errorThrown) {
			alert("error data : " + errorThrown);
		}
	});

}


function update(value) {	
	
// event.preventDefault();
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/UpdateAssignment";
	
	// Get form
    $.ajax({
        type: "POST",
        url: service_url,
        data: {
        	task_id : value,
        	question : $("#Q"+value).val(),
        	ldate : $("#LD"+value).val()
        },
        success: (data) => {
            alert(data);
            $(location).attr(
					'href',
					$(location).attr('protocol') + "//"
							+ $(location).attr('host')
							+ "/Faculty/Dashboard");
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });
}



function deleteRecord(value) {	
	
// event.preventDefault();
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/DeleteAssignment";
	
	// Get form
    $.ajax({
        type: "POST",
        url: service_url,
        data: {
        	task_id : value,
        	question : $("#Q"+value).val(),
        	ldate : $("#LD"+value).val()
        },
        success: (data) => {
            alert(data);
            $(location).attr(
					'href',
					$(location).attr('protocol') + "//"
							+ $(location).attr('host')
							+ "/Faculty/Dashboard");
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });
}

function createAssignment() {
	

// event.preventDefault();
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/CreateAssignment";
	
	// Get form
    $.ajax({
        type: "POST",
        url: service_url,
        data: {        	
        	question : $("#taskData").val(),
        	dateID : $("#dateID").val()
        },
        success: (data) => {
            alert(data);
            $(location).attr(
					'href',
					$(location).attr('protocol') + "//"
							+ $(location).attr('host')
							+ "/Faculty/Dashboard");
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });	
		
}

// Show Download
function showDownload() {	
	
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/DownloadAssignmentListing";	
	
	$( "#removePart" ).remove();
	$( ".removePart" ).remove();

	$.ajax({

		url : service_url,
		type : "post",
		dataType : "json",
		success : function(responseData) {
			var hl = "<div class='col-lg-12' id='removePart'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>" +
					"<th style='width: 33%;' scope='col'>Sr No.</th>"+
					"<th style='width: 33%;' scope='col'>Student Username</th>"+
			"<th style='width: 34%;' scope='col'>Action</th>";
			for (var i = 0; i < responseData.length; i++) {
				var html = "<div class='col-lg-12 removePart' ><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>";
				
				html += "<th style='width: 33%;' scope='col'>"+(i+1)+"</th>";
				html += "<th style='width: 33%;' scope='col'>"+responseData[i][1]+"</th>";				
				html += "<th style='width: 33%;' scope='col'><input type='submit' onclick='download("+responseData[i][0]+")' value='Download' class='btn btn-success' /></th>";
				
				html += "</tr></thead></table></div></div>";
				hl += html;
			}
			
			hl += "</tr></thead></table></div></div>";
			
			$("#downloadData").append(hl);			
		},
		error : function(errorThrown) {
			alert("error data : " + errorThrown);
		}
	});

}


function download(value) {
	

// event.preventDefault();
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Faculty/DownloadAssignment";
	
	// Get form
    $.ajax({
        type: "POST",
        url: service_url,
        data: {        	
        	stutaskID : value
        },        
        success: (data) => {
        	var status = data.split("~");
        	if(status[0] == "Success") {
        		alert("Your file downloaded successfully that's location-> C:\\"+status[1]+".txt");	
        	} else {
        		alert("Something Wrong! After sometime download this file!");
        	}
        		
        	
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });	
		
}
