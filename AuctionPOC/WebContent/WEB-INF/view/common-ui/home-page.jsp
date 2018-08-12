<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css"
	href="/AuctionPOC/assets/css/style.css"></link>
<script src="/AuctionPOC/assets/js/center.js"></script>

</head>
<body>
	<%
		String username = (String) request.getAttribute("username");
		session.setAttribute("username", username);
	%>
	<input type="hidden" id="hidden" value="<%= username%>">
	<div class="container">
		<!--_____________________________________Header______________________________________-->
		<div class="header">
			<div class="navigation">
				<ul class="nav">
					<li><a href="#" onclick="selected(this)">Home</a></li>
					<li><a href="#" onclick="selected(this)">My items</a></li>
					<li><a href="#" onclick="selected(this)">Search</a></li>
					<li><a href="#" onclick="selected(this)">Contact</a></li>
					<li><a href="/AuctionPOC/auctionPage/addItem" onclick="selected(this)">Add item</a></li>
				</ul>
			</div>
		</div>

		<!--_____________________________________ Center ______________________________________-->
		<div class="center"></div>
	</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css"
	href="/AuctionPOC/assets/css/style.css"></link>
<script src="/AuctionPOC/assets/js/center.js"></script>

</head>
<body>
	<%
		String username = (String) request.getAttribute("username");
		session.setAttribute("username", username);
	%>
	<input type="hidden" id="hidden" value="<%= username%>">
	<div class="container">
		<!--_____________________________________Header______________________________________-->
		<div class="header">
			<div class="navigation">
				<ul class="nav">
					<li><a href="#" onclick="selected(this)">Home</a></li>
					<li><a href="#" onclick="selected(this)">My items</a></li>
					<li><a href="#" onclick="selected(this)">Search</a></li>
					<li><a href="#" onclick="selected(this)">Contact</a></li>
					<li><a href="/AuctionPOC/auctionPage/addItem" onclick="selected(this)">Add item</a></li>
				</ul>
			</div>
		</div>

		<!--_____________________________________ Center ______________________________________-->
		<div class="center"></div>
	</div>
</body>
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
</html>