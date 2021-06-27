<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<style>

/* Google Font CDN Link */
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

:root { -
	-black-color: #11101d; -
	-white-color: #fff; -
	-sky-color: #E4E9F7; -
	-light-black: #1d1b31;
}

body {
	position: relative;
	min-height: 100vh;
	width: 94%;
	overflow: hidden;
}

::selection {
	color: #fff;
	background: #11101d;
}

.sidebar {
	position: fixed;
	top: 0;
	left: 0;
	height: 100%;
	width: 220px;
	background: #11101d;
	padding: 6px 14px;
	z-index: 99;
	transition: all 0.5s ease;
}

.sidebar ul {
	margin-top: 20px;
}

.sidebar ul li {
	position: relative;
	height: 50px;
	width: 100%;
	margin: 5px 0;
	list-style: none;
	line-height: 50px;
}

.sidebar ul li .tooltip {
	position: absolute;
	left: 125px;
	top: 0;
	transform: translate(-50%, -50%);
	border-radius: 6px;
	height: 35px;
	width: 120px;
	background: #fff;
	line-height: 35px;
	text-align: center;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	transition: 0s;
	opacity: 0;
	pointer-events: none;
	display: block;
}

.sidebar ul li .tooltip::before {
	content: '';
	width: 0;
	height: 0;
	border-top: 10px solid transparent;
	border-bottom: 10px solid transparent;
	border-right: 10px solid #fff;
	position: absolute;
	left: -8px;
	top: 7px;
}

.sidebar ul li:hover .tooltip {
	transition: all 0.5s ease;
	opacity: 1;
	top: 50%;
}

.sidebar ul li input {
	position: absolute;
	height: 100%;
	width: 100%;
	left: 0;
	top: 0;
	border-radius: 12px;
	outline: none;
	border: none;
	background: #1d1b31;
	font-size: 18px;
	color: #fff;
}

.sidebar ul li input:hover {
	background: #656565;
}


.sidebar ul li a {
	color: #fff;
	display: flex;
	align-items: center;
	text-decoration: none;
	border-radius: 12px;
	white-space: nowrap;
	transition: all 0.4s ease;
}

.sidebar ul li a:hover {
	color: #11101d;
	background: #fff;
}

.sidebar ul li i {
	font-size: 18px;
	font-weight: 400;
	height: 50px;
	min-width: 50px;
	border-radius: 12px;
	line-height: 50px;
	text-align: center;
}

.sidebar .links_name {
	font-size: 15px;
	font-weight: 400;
	opacity: 0;
	pointer-events: none;
	transition: all 0.3s ease;
}

.sidebar.active .links_name {
	transition: 0s;
	opacity: 1;
	pointer-events: auto;
}

.sidebar .content {
	position: absolute;
	color: #fff;
	bottom: 0;
	left: 0;
	width: 100%;
}

.sidebar .content .user {
	position: relative;
	padding: 10px 6px;
	height: 60px;
	background: none;
	transition: all 0.4s ease;
}

.sidebar.active .content .user {
	background: #1d1b31;
}

.content .user .user_details {
	display: flex;
	align-items: center;
	opacity: 0;
	pointer-events: none;
	white-space: nowrap;
	transition: all 0.4s ease;
}

.sidebar.active .user .user_details {
	opacity: 1;
	pointer-events: auto;
}

#log_out {
	position: absolute;
	bottom: 5px;
	left: 50%;
	transform: translateX(-50%);
	min-width: 50px;
	line-height: 50px;
	font-size: 20px;
	border-radius: 12px;
	text-align: center;
	transition: all 0.4s ease;
}

.sidebar.active .user #log_out {
	left: 80%;
	background: none;
}

.home_content {
	position: absolute;
	height: 100%;
	width: calc(100% - 78px);
	left: 180px;
	background: #E4E9F7;
	padding: 20px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	transition: all 0.5s ease;
}

.home_content_ongoing {
	position: absolute;
	height: 100%;
	width: calc(100% - 78px);
	left: 50px;
	background: #E4E9F7;
	padding: 20px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	transition: all 0.5s ease;
}

.home_content .text {
	font-size: 25px;
	font-weight: 600;
	color: #1d1b31;
	margin-bottom: 15px;
}

.home_content input {
	margin-bottom: 10px;
}

#mainImg {
	width: 1250px;
	margin-bottom: 50px;
}

#telnet{
background:#E4E9F7;
color:black;
font-size:40px;
font-style:italic;
font-weight: 900;

}
</style>

<meta charset="UTF-8">

<!-- Boxicons CDN Link -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="sidebar">



		<ul class="nav_list">

			<li> <input type="submit" value="Telnet" id="telnet"> 
			</a></li>

			<br>
			<br>
			<br>


			<li><a href="case.jsp"> <input type="submit" value="FAQ"
					id="addCase"> <span class="tooltip">Frequantly Asked</span>
			</a></li>


			<br>

			<form action="AddCaseServlet" method="post">
				<li><input type="submit" value="Open Case" id="addCase">
					<span class="tooltip">Open New Case</span></li>
			</form>

			<br>

			<form action="OngoingCasesServlet" method="post">
				<li><input type="submit" value="Pending Cases"> <span
					class="tooltip">Pending Cases</span></li>
			</form>

			<br>

			<form action="SolvedCaseServlet" method="post">
				<li><input type="submit" value="Solved Cases"> <span
					class="tooltip">Solved Cases</span></li>
			</form>

			<br>

			<form action="#" method="post">
				<li><input type="submit" value="Feedback"> <span
					class="tooltip">Feedback</span></li>
			</form>




		</ul>
		<div class="content">
			<div class="user">
				<div class="user_details">
					<img src="images/profile.jpg" alt="">
					<div class="name_job"></div>
				</div><a href="UserLogin.jsp">
				<i class='bx bx-log-out' id="log_out"></i>
				</a>
			</div>
		</div>
	</div>
	<div class="home_content"></div>
</body>
</html>