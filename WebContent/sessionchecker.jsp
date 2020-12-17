<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.retailbanking.util.SessionChecker" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(SessionChecker.isValidSession(session)){
	
	request.setAttribute("message","Invalid Session.Please Login Again");
	request.getRequestDispatcher("login.jsp").forward(request,response);
	System.out.println("Invalid Session");
	return;
}
%>

</body>
</html>