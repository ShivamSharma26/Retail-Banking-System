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

<div class="center">
<h3>Search Account</h3>
	<form action="AccountController"  method="post">
		<table>
			<tr>
				<th align="left">Enter Account ID</th>
				<td><input type="number" name="accId" /></td>
			</tr>
			<tr></tr>
			<tr>
			<td></td>
			  <td align="center"><strong>OR</strong>  </td>
			  </tr>
			<tr>
				<th align="left"> Enter Customer ID</th>
				<td><input type="number" name="customerId" /></td>
			</tr>
			<tr>
				<th align="left"> Enter Account Type</th>
				<td>
				<select name="accountType"   class="type-select">
								<option value="none" selected hidden>Select</option>
								<option value="S">S</option>
								<option value="C">C</option>
				</select>
				</td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="action" value="viewAccountDetails">
				<td><input type="submit" value="View"/></td>
			</tr>
			
		</table>
		
	</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>