<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Case</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ include file="sidebar.jsp"%>
</head>
<body>
	<div class="home_content">
		<div class="home_content_ongoing">

			<!-- this div for show validate information of form -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="alert alert-success" style="text-align: center;">
						<strong>Info : User Allow to Change Contact Number and
							Case Information Only</strong>
					</div>

				</div>
			</div>


			<c:forEach var="tempCase" items="${update_case_details}">




				<!-- show Current data -->

				<form class="form-horizontal" action="UpdateCaseServlet"
					method="post">
					<div class="form-group">
						<label class="control-label col-sm-2" for="userName">User
							Name :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="userName" readonly
								value="${tempCase.userName}">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="connNumber">Connection
							:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="${tempCase.connNumber}" readonly name="connNumber">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="contactNumber">Contact
							Number :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								name="updateContactNumber" value="${tempCase.contactNumber}">
						</div>
					</div>




					<div class="form-group">
						<label class="control-label col-sm-2" for="caseDetails">Case
							Details :</label>
						<div class="col-sm-10">
							<textarea id="case" class="form-control" name="updateCaseDetails"
								rows="8" cols="50">${tempCase.caseDetails}</textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" value="${tempCase.refNumber}"
								name="refNumber"> <input type="hidden" value="update"
								name="updateCase">
							<button type="submit" class="btn btn-default">Update</button>
						</div>
					</div>
				</form>


			</c:forEach>



		</div>
	</div>

</body>
</html>