<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errMessage=(String)request.getAttribute("errMessage"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="searchCustomer.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js">	</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>

<main  style="height:400px">

<div class="center">
<h3><b>Search Customer</b></h3>
	<form action="BankController" method="post" onsubmit="return validateData();" >
		<table>
			<tr>
				<th align="left"> Enter SSNID</th>
				<td><input type="number" name="ssnId" id="ssnid"
							title="SSNId must be 9 digit numeric" /></td>
			</tr>
			<tr></tr>
			<tr>
			<td></td>
			  <th align="center"> OR </th>
			  </tr>
			<tr>
				<th align="left"> Enter Customer ID</th>
				<td><input type="number" name="customerId" title="CustomerId must be 9 digit numeric"/></td>
			</tr>
			<tr><span>(*) One field is mandatory</span></tr>
			<tr>
				<td><input type="hidden" name="action" value="search"/></td>
				<td><input type="submit" value="Search"/></td>
			</tr>
			<tr></tr>
			</br>
		</table>
	</form>
	</div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>