<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   


<!DOCTYPE html>
<html>
	<head>
		<title>WithDraw Money</title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="searchCustomer.css">
	</head>
	<body>
	
	
	
	<jsp:include page="header1.jsp"></jsp:include>
	<jsp:include page="sessionchecker.jsp"></jsp:include> 

	
		<div class="center">
			<h3>Withdraw Money</h3>
			<form action="AccOperationController" method="post" >
				<table>
					<tr>
						<th>
							Customer Id:
						</th>
						<td>
							<%=(String)request.getAttribute("id")%>
						</td>
					</tr>
					
					<tr>
						<th>
							Account Id:
						</th>
						<td>
							<input type="text" name="AccountId"  value="<%=(String)request.getAttribute("accid")%>"/>
						</td>
					</tr>
					
					<tr>
						<th>
							Account Type:
						</th>
						<td>
							<%=request.getAttribute("acctype")%>
						</td>
					</tr>
					
					<tr>
						<th>
							Balance:
						</th>
						<td>
							<%=(String)request.getAttribute("balance")%>
						</td>
					</tr>
					
					<tr>
						<th>
							WithDraw Amount:
						</th>
						<td>
							<input type="text" name="withdraw" required />
						</td>
					</tr>
					
					<tr id="subb">
						<td></td>
						<td>
							<input type="hidden" name="action" value="withdrawAmount">
							<input type="submit" name="submit" value="submit" />
						</td>
					</tr>
					

				</table>
			</form>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>  
	</body>
</html>