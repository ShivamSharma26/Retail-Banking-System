<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="searchCustomer.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>

<main  style="height:400px">

<div class="center">
<h4>Search Customer</h4>
	<form action="BankController" method="post" >
		<table>
			<tr>
				<th align="left">SSNID</th>
				<td><input type="number" name="ssnId" /></td>
			</tr>
			<tr></tr>
			<tr>
			  <td align="center"> OR </td>
			  </tr>
			<tr>
				<th align="left">Customer ID</th>
				<td><input type="number" name="customerId" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="action" value="delete"/></td>
				<td><input type="submit" value="Delete"/></td>
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