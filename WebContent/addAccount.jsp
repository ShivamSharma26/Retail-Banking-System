<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="searchCustomer.css">
 <meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js">	
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include> 

	
		<div class="center">
			<h3 align="center">Create Account</h3>
			<form action="AccountController" method="post"  class="form" onsubmit="return validateData();">
				<table class="content">
					<tr>
						<th>
							Customer Id:<span>*</span>
						</th>
						<td>
							<input type="text" name="custid" required id="custid"/>
						</td>
					</tr>
					
					<tr>
						<th>
							Account type:<span>*</span>
						</th>
						<td>
							<select name="acctype"   class="state-select" >
								<option value="none" selected hidden>Select</option>
								<option value="C">C</option>
								<option value="S">S</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>
							Deposit Amount:<span>*</span>
						</th>
						<td>
							<input type="number" name="balance" required />
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<span>(*) Fields are compulsory </span>
						</td>
						
					</tr>
					
					<tr>
						<td>
							<input type="hidden" name="action" value="addAccount"></td>
							<td><input type="submit" name="submit" value="submit" >
						</td>
					</tr>
					

				</table>
			</form>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include> 
	</body>
</body>
</html>