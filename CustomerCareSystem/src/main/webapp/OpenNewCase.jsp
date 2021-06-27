<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open New Case</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<%@ include file="sidebar.jsp"%>

<body>


	<div class="home_content">

		<div>

			<!-- this div for show validate information of form -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="alert alert-success" style="text-align: center;">
						<strong>Info : ${status}</strong>
					</div>

				</div>
			</div>

			<!-- demostrate customer data using jstl -->
			<c:forEach var="tempCustomer" items="${customer_details}">


				<!-- Customer case opening form -->
				<form class="form-horizontal" action="AddCaseServlet" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2" for="userName">User
							Name :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="userName" readonly
								value="${tempCustomer.userName}">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="connNumber">Connection
							:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								value="${tempCustomer.connectionNumber}" readonly
								name="connNumber">
						</div>
					</div>




					<div class="form-group">
						<label class="control-label col-sm-2" for="contactNumber">Contact
							Number :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"
								placeholder="Contact Number" name="contactNumber">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="caseCategory">
							Case Category </label>

						<div class="col-sm-10">
							<select id="cars" class="form-control" name="caseCategory">
								<option value="1">Mobile Connection</option>
								<option value="2">Fixed Line & Broadband</option>
								<option value="3">Enterprise Support</option>
								<option value="4">New Connections</option>
							</select>
						</div>


					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="caseDetails">Case
							Details :</label>
						<div class="col-sm-10">
							<textarea id="case" class="form-control" name="caseDetails"
								rows="8" cols="50" placeholder="case details"></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form>


			</c:forEach>



		</div>

	</div>
</body>
</html>