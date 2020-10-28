// Window On Load
window.onload = function() {

	showList();

}

// Show List
function showList() {	
	
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Student/AssignmentListing";

	$.ajax({

		url : service_url,
		type : "post",
		dataType : "json",
		success : function(responseData) {
			var hl = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>" +
					"<th style='width: 25%;' scope='col'>Questions</th>"+
			"<th style='width: 25%;' scope='col'>Last Date</th>"+
			"<th style='width: 25%;text-align:left;' scope='col'>File Upload</th>"+
			"<th style='width: 25%;text-align:right;' scope='col'>Action</th>";
			for (var i = 0; i < responseData.length; i++) {
				var html = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>";
				
				html += "<th style='width: 25%;' scope='col'>"+responseData[i][0]+"</th>";
				html += "<th style='width: 25%;' scope='col'>"+responseData[i][1]+"</th>";
				html += "<th style='width: 50%;' scope='col'><form method='POST' enctype='multipart/form-data' id='F"+responseData[i][3]+"'>" +
						"<input type='hidden'  value='"+responseData[i][3]+"' id='TID"+responseData[i][3]+"' name='taskID' />" +
								"<input type='hidden' value='"+responseData[i][2]+"' id='FU"+responseData[i][2]+"' name='facultyU' />" +
								"<input type='file' style='float:left;' id='T"+responseData[i][3]+"' name='uploadfile' class='btn btn-default' />";
				html += "<input type='submit' style='float:right;' onclick='assignment("+responseData[i][3]+")' value='Upload' class='btn btn-primary' /></form></th>";
				
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


function assignment(value) {	
	
//	event.preventDefault();	
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Student/UploadAssignment";
	
	// Get form
    var form = $('#F'+value)[0];
    var data = new FormData(form);
 
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: service_url,
        data: data,
        processData: false, // prevent jQuery from automatically transforming
							// the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            alert(data);
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });
}

