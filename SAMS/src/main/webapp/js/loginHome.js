function submit() {
	
	var url = $(location).attr('protocol') + "//" + $(location).attr('host')
			+ "/Common/LoginHomeStatus";

	$.ajax({
		method : "POST",
		url : url,
		data : {
			username : $("#username").val(),
			password : $("#password").val(),
			usertype : $("#user_type").val()
		}
	}).done(function(result) {		
		if (result == "Student") {
			$(location).attr('href',$(location).attr('protocol') + "//" + $(location).attr('host')
					+ "/Student/Dashboard");
		} else if (result == "Faculty") {
			$(location).attr('href',$(location).attr('protocol') + "//" + $(location).attr('host')
					+ "/Faculty/Dashboard");
		} else if (result == "Admin") {
			$(location).attr('href',$(location).attr('protocol') + "//" + $(location).attr('host')
					+ "/Admin/Dashboard");
		}else if (result == "Same") {
			$(location).attr('href',$(location).attr('protocol') + "//" + $(location).attr('host')
					+ "/Common/Login");
		}
	});
	
}