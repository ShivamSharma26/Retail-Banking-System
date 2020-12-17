<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   


<!DOCTYPE html>
<html>
	<head>
		<title>Deposit Money</title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="searchCustomer.css">
	</head>
	<body>
	
	
	
	<jsp:include page="header1.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include> 

	
		<div class="center">
			<h3>Deposit Money</h3>
			<form action="AccOperationController" method="post" >
				<table>
					<tr>
						<td>
							Customer Id:
						</td>
						<td>
							<%=(String)request.getAttribute("id")%>
						</td>
					</tr>
					
					<tr>
						<td>
							Account Id:
						</td>
						<td>
						<input type="text" name="AccountId"  value="<%=(String)request.getAttribute("accid")%>"/>
							
						</td>
					</tr>
					
					<tr>
						<td>
							Account Type:
						</td>
						<td>
							<%=request.getAttribute("acctype")%>
						</td>
					</tr>
					
					<tr>
						<td>
							Balance:
						</td>
						<td>
							<%=(String)request.getAttribute("balance")%>
						</td>
					</tr>
					
					<tr>
						<td>
							Deposit Amount:
						</td>
						<td>
							<input type="text" name="deposit" required />
						</td>
					</tr>
					
					<tr id="subb">
						<td></td>
						<td>
							<input type="hidden" name="action" value="depositAmount">
							<input type="submit" name="submit" value="submit" />
						</td>
					</tr>
					

				</table>
			</form>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include> 
	</body>
</html>