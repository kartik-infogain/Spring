<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/AuctionPOC/assets/css/style.css"></link>
<style type="text/css">
button.add-item {
	padding: 0.6em 1.5em;
	border: 3px solid #232529;
	border-radius: 40px;
	font-weight: 700;
	color: #000;
	font-size: 1.25em;
	background: white;
}

button.add-item:hover, button.add-item:focus {
	background: #232529;
	color: #fff;
}

.add-item, .no-js .add-item {
	display: block;
	float: right;
}

.add-item {
	border-color: #232529;
	color: #232529;
}
</style>
</head>
<body>
	<%
		String username = (String) request.getAttribute("username");
		session.setAttribute("username", username);
	%>
	<h1>
		hello
	</h1>
	<form action="/AuctionPOC/auctionPage/addItem" method="post">
		<button class="add-item" type="submit">Add item</button>
	</form>
	
</body>
</html>