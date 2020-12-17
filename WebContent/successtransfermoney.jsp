<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Successful Transfer</title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="style1.css">
	</head>
	<body>
	
	<%
		String balance = (String)request.getAttribute("balance");
		String msg = (String)request.getAttribute("message");
	%>
	
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include> 

	
		<div class="center">
		
			<p>
			<%=request.getAttribute("message")%>
			</p>
			<br><br>
			<p>
			 Source Account balance : <%=request.getAttribute("srcbalance")%>
			</p>
			<p>
			 Destination Account balance : <%=request.getAttribute("destbalance")%>
			</p>
			<a href="index.jsp">HOME</a>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include> 
		
	</body>
	
</html>
		