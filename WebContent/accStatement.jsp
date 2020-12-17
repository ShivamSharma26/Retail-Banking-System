<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Statement</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h2 style="text-align: center;">Account Statement</h2>
	<form method="post" action="accountStatement.jsp">
		<table align="center">
			<tr>
				<td>Account ID</td>
				<td><input type="number" name="accntId"
					title="Account id must be 9 digit no"></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="text" name="sdate"></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="text" name="edate"></td>
			</tr>
		</table>
		<p style="text-align: center; color: red;">(*)fields are mandatory</p>
		<p style="text-align: center;">
			<input type="submit" value="Submit" name="btn">
		</p>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>