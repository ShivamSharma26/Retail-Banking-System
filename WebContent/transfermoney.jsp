<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<!Doctype html>

<html>
	<head>
	
		<title>Transfer Money</title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="searchCustomer.css">
		
	</head>
	<body>
	<jsp:include page="header1.jsp"></jsp:include>
    <jsp:include page="sessionchecker.jsp"></jsp:include>
		
	
		<div class="center">
			<h3>Transfer Money</h3>
			<form action="AccOperationController" method="post" >
				<table>
					<tr>
						<td>
							Customer Id:
						</td>
						<td>
							<input type="text" name="CustId"  value="<%=(String)request.getAttribute("id")%>"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Source Account Type:
						</td>
						<td>
							<select name="srcacctype"   class="state-select">
								<option value="none" selected hidden>Select</option>
								<option value="C">C</option>
								<option value="S">S</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>
							Target Account Type:
						</td>
						<td>
							<select name="destacctype"   class="state-select">
								<option value="none" selected hidden>Select</option>
								<option value="C">C</option>
								<option value="S">S</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>
							Transfer Amount:
						</td>
						<td>
							<input type="text" name="transferamount" required />
						</td>
					</tr>
					
					<tr id="subb">
						<td>
						</td>
						<td>
							<input type="hidden" name="action" value="transferAmount">
							<input type="submit" name="submit" value="submit" />
						</td>
					</tr>
					

				</table>
			</form>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
	
</html>