<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet"type="text/css" href="header.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container-fluid  bg-dark">
		<div class="container text-warning">
			<h1><b>FEDChoice</b> <span style="color:white"><strong>Bank</strong></span> </h1>
		</div>
		<div class="container">
			<div class="nav-bar">
				<ul>
					<li><a href="#"><b>Home</b></a></li>
					<li class="dropdown">
						<a href="#"><b>Customer Manangement</b></a>
						<ul>
							<li><a href="createCustomer.jsp"><b>Create Customer</b></a></li>
							<li><a href="searchCustomer.jsp"><b>Update Customer</b></a></li>
							<li><a href="viewCustomer.jsp"><b>Delete Customer</b></a></li>
						</ul>
					</li>
					<li class="dropdown">
					<a href="#"><b>Account Manangement</b></a>
						<ul >
							<li><a href="addAccount.jsp"><b>Create Account</b></a></li>
							<li><a href="searchAccount.jsp"><b>Delete Account</b></a></li>
						</ul>	
					</li>
					<li class="dropdown">
					<a href="#"><b>Status Details</b></a>
						<ul >
							<li><a href="customerStatus.jsp"><b>Customer Details</b></a></li>
							<li><a href="accountStatus.jsp"><b>Account Details</b></a></li>
						</ul>		
					</li>
					<li class="dropdown">
					<a href="#"><b>Account Operations</b></a>
						<ul >
							<li><a href="viewAccountDetails.jsp"><b>Account Transactions</b></a></li>
							<li><a href="accStatement.jsp"><b>Account Statement</b></a></li>
						</ul>	
					</li>
					<li><a href="logout.jsp"><b>Logout</b></a></li>
					
					
					</ul>
		</div>
	</div>
</div>
			
</body>
</html>