<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.retailbanking.util.DatabaseUtil"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="searchCustomer.css">
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<script type="text/javascript" src="validation.js">
	
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include>
	<%
		String cust_id = (String) request.getAttribute("customerId");
	String ssn_id = (String) request.getAttribute("SSNId");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		con = DatabaseUtil.getConnection();
		System.out.println(con);
		String sql = "SELECT * FROM CustomerInfo where id=? or ssnid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, cust_id);
		ps.setString(2, ssn_id);
		rs = ps.executeQuery();
		while (rs.next()) {
	%>
	<div class="center">
		<h2 align="center">
			<font><strong>Update Customer</strong></font>
		</h2>
		<form method="post" action="BankController"
			onsubmit="return validateData();">
			<table class="content">
				<tr>
					<td>SSN Id</td>
					<td><%=rs.getString("ssnid")%></td>
					<!-- fetching ssn id -->
				</tr>
				<tr>
					<td>Customer Id</td>
					<td><%=rs.getString("id")%></td>
					<!-- fetching customer id -->
				</tr>
				<tr>
					<td>Old Customer Name</td>
					<td><%=rs.getString("name")%></td>
					<!-- fetching customer name -->
				</tr>
				<tr>
					<td>New Customer Name</td>
					<td><input type="text" name="newCustName" size="25"
						id="custname" title="Name should contain only alphabets "></td>
					<td><small id="s_name"></small></td>
				</tr>
				<tr>
					<td>Old Address</td>
					<td><%=rs.getString("address")%></td>
					<!-- fetching customer address -->
				</tr>
				<tr>
					<td>New Address</td>
					<td><input type="text" name="newAddress" size="25" id="addr"
						title="Enter Address "></td>
					<td><small id="s_addr"></small></td>
				</tr>
				<tr>
					<td>Old Age</td>
					<td><%=rs.getString("age")%></td>
				</tr>
				<tr>
					<td>New Age</td>
					<td><input type="text" name="newAge" size="25" id="age"
						maxlength="3" title="Enter valid age"></td>
					<td><small id="s_age"></small></td>
				</tr>
				<tr align="center">
					<td ><input type="hidden" name="action"
						value="updateCustomer"></td>
						<td> <input type="submit" name="Update"
						value="Update" /></td>
				</tr>

			</table>
			<input type="hidden" name="id" value="<%=rs.getString("id")%>">
			<br>
		</form>
	</div>



	<%
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {

	}
	%>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>