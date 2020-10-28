<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<div class='col-lg-12'>
					<div class='col-auto'>
						<table class='table text-center table-responsive'>
							<thead class='thead-dark'>
								<tr>
									<th style='text-align: center;' scope='col'><input
										type='submit' id="createAssign" value='Create Assignment'
										class='btn btn-primary' /></th>
									<th style='text-align: center;' scope='col'><input
										type='submit' id="downloadAssign" value='Download Assignment'
										class='btn btn-primary' /></th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>

			<div class="row" id="insertData"></div>

			<div class="row" id="createAssignment">

				<div class="col-lg-12">
				<p><b>Last Date : </b></p>
					<input type='date' class="form-control rounded-0" id="dateID" />
					<br>
					<p><b>Assignment : </b></p>
					<textarea class="form-control rounded-0" id="taskData" rows="8"></textarea>
					<br> <input type='submit' onclick="createAssignment()"
						style="float: right;" value='Submit' class='btn btn-primary' />
				</div>

			</div>

			<div class="row" id="downloadData"></div>

		</div>
	</div>

</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../../js/facultyActivity.js"></script>
</html>