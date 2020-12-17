<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errMessage=(String)request.getAttribute("errMessage"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="searchCustomer.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>

<main  style="height:400px">

<div class="center">
<h3>Search Account</h3>
	<form action="AccountController" method="post" >
	<% if(errMessage!=null){ %>
				 <h4 style="color:red;"><%=errMessage%></h4>
				<% } %>
		<table>
			<tr>
				<td align="left"><b> Enter SSNID:</b></td>
				<td><input type="number" name="ssnId" 
				id="ssnid"
							title="SSNId must be 9 digit numeric" >
						</td>
						<td><small id="s_id"></small></td>
			</tr>
			<tr></tr>
			<tr>
			<td></td>
			  <td align="center"><b>OR</b> </td>
			  </tr>
			<tr>
				<td align="left"><b>Enter Customer ID:</b></td>
				<td><input type="number" name="customerId" title="Customer Id must be 9 digit numeric" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="action" value="search"/></td>
				<td><input type="submit" value="Search"/></td>
			</tr>
			<tr></tr>
		</table>
		<span>(*) One field is mandatory</span>
	</form>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>