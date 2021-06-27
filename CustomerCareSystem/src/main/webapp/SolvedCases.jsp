<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solved Case</title>

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




			<table class="table table-hover">
				<thead class="table-dark ">
					<tr class="bg-primary">
						<th>Reference Number</th>
						<th>Assistant</th>
						<th>Case</th>
						<th>status</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempCase" items="${case_details}">
						<tr>
							<td>${tempCase.refNumber}</td>
							<td>${tempCase.assistantUserName}</td>
							<td>${tempCase.assistantReply}</td>
							<td>${tempCase.caseStatus}</td>

							<form action="DeleteCaseServlet" method="post">
								<input type="hidden" name="deleteRefNumber"
									value="${tempCase.refNumber}">
								<td><input type="submit" value="Delete" class="bg-danger"></td>
							</form>
						</tr>


					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>