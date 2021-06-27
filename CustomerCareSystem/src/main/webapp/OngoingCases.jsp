<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Cases</title>

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

			<!-- demostrate pending cases -->

			<table class="table table-hover">
				<thead class="table-dark ">
					<tr class="bg-primary">
						<th>Reference Number</th>
						<th>Case</th>
						<th>status</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<!-- demostrate cade data using jstl -->
					<c:forEach var="tempCases" items="${customer_case_details}">
						<tr>
							<td>${tempCases.refNumber}</td>
							<td>${tempCases.caseDetails}</td>
							<td>${tempCases.status}</td>


							<!-- form for Update post -->
							<form action="UpdateCaseServlet" method="post">
								<input type="hidden" name="updateCase" value="updatePage">
								<input type="hidden" name="updateRefNumber"
									value="${tempCases.refNumber}">

								<td><input type="submit" value="Update" class="bg-success"></td>
							</form>


						</tr>


					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>