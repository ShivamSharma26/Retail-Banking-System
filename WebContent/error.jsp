<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="style1.css">
	</head>
	<body>
	
	
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include> 

	
		<div class="center">
		
			<p>
			<%=request.getAttribute("errmessage")%>
			</p>
			<br><br>
			<a href="index.jsp">HOME</a>
		
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include> 
		
	</body>
	
</html>