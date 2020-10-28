// Window On Load
window.onload = function() {
	
	showList();
	
}

// Show List
function showList() {	
	
	var service_url = $(location).attr('protocol') + "//" + $(location).attr('host')
	+ "/Admin/AssignmentListing";

	$.ajax({

		url : service_url,
		type : "post",
		dataType : "json",
		success : function(responseData) {
			var hl = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>" +
					"<th style='width: 20%;' scope='col'>Sr. No.</th>"+
					"<th style='width: 20%;' scope='col'>Questions</th>"+
			"<th style='width: 20%;' scope='col'>Last Date</th>"+
			"<th style='width: 20%;' scope='col'>Update Action</th>";
			for (var i = 0; i < responseData.length; i++) {
				var html = "<div class='col-lg-12'><div class='col-auto'><table class='table text-center table-responsive'><thead class='thead-dark'><tr>";
				
				html += "<th style='width: 20%;' scope='col'>"+(i+1)+"</th>";
				html += "<th style='width: 20%;' scope='col'><textarea class='form-control rounded-0'  id='Q"+responseData[i][0]+"'>"+responseData[i][1]+"</textarea></th>";
				html += "<th style='width: 20%;' scope='col'><input type='text' value='"+responseData[i][2]+"' id='LD"+responseData[i][0]+"' /></th>";								
				html += "<th style='width: 20%;' scope='col'><input type='submit' onclick='update("+responseData[i][0]+")' value='Update' class='btn btn-primary' /></th>";				
				
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
	+ "/Admin/UpdateAssignment";
	
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
							+ "/Admin/Dashboard");
        },
        error: (e) => {
        	alert(e.responseText)            
        }
    });
}
