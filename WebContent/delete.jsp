<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.retailbanking.util.DatabaseUtil"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<%
String cust_id=(String)request.getAttribute("customerId");
String ssn_id=(String)request.getAttribute("SSNId");
session.setAttribute("custId", cust_id);
session.setAttribute("ssnId", ssn_id);

Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
%>

<%
try{ 
con = DatabaseUtil.getConnection();
System.out.println(con);
String sql ="SELECT * FROM CustomerInfo where id=? or ssnid=?";
ps=con.prepareStatement(sql);
ps.setString(1, cust_id);
ps.setString(2,ssn_id);

rs = ps.executeQuery();
while(rs.next()){
%>

<div class="center">
<h3 >Delete Customer</h3>
<form method="post" action="BankController">

<table > 


<tr><th align="left">SSN Id :</th>
<td><%=rs.getString("ssnid") %></td>
</tr>
<tr><th align="left">Customer Id :</th>
<td><%=rs.getString("id") %></td></tr>>
<tr><th align="left">Customer Name :</th>
<td><%=rs.getString("name") %></td></tr>
<tr><th align="left">Age :</th>
<td> <%=rs.getString("age") %></tr>
<tr><th align="left">Address :</th>
<td><%=rs.getString("address") %></td></tr>

<tr><td><input type="hidden" name="action" value="confirmDelete">
<input type="submit" name="Confirm Delete" value="Confirm Delete"/></td>
<td><input type="hidden" name="action" value="cancel">
<input type="submit" name="Cancel" value="Cancel"/></td></tr>
</table>


</form>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
finally{
	
}
%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>