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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>
<%

String acc_id=(String)request.getAttribute("AccountId");
System.out.println(acc_id);
System.out.println("xdfcghcgh");
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
%>

<br>
<br>
<% try{
	con=DatabaseUtil.getConnection();
	String query ="select * from Account1 where accid=?";
	ps=con.prepareStatement(query);
	ps.setString(1,acc_id);
	
	rs=ps.executeQuery();
	
	while(rs.next()){
		String id=rs.getString("id");
%>
<%
request.setAttribute("id",id);
request.setAttribute("accid",rs.getString("accid"));
request.setAttribute("acctype",rs.getString("acctype"));
request.setAttribute("balance",rs.getString("balance"));
System.out.println("jsp"+id);%>
<div class="center">
<h3 align="center"><strong>View Details</strong></h3>
<form method="post" action="ButtonController">
<input type="hidden" name="id" value="<%=rs.getString("id")%>">
<input type="hidden" name="accid" value="<%=rs.getString("accid")%>">
<input type="hidden" name="acctype" value="<%=rs.getString("acctype")%>">
<input type="hidden" name="balance" value="<%=rs.getString("balance")%>">
<table class="content">
<tr>
<th>Customer Id:</th>
<td><%=rs.getString("id")%></td> 
</tr>
<tr>
<th>Account Id:</th>
<td><%=rs.getString("accid")%></td> 
</tr>
<tr>
<th>Account type:</th>
<td><%=rs.getString("acctype")%></td> 
</tr>
<tr>
<tr>
<th>Account Balance:</th>
<td><%=rs.getString("balance") %></td>
</tr>
<tr>
<td>

<input type="submit" name="action" value="Deposit" />
</td>
<td>

<input type="submit" name="action" value="Withdraw" />
</td>
<td>

<input type="submit" name="action" value="TransferMoney" />
</td>
</tr>
</table>
</form>	
</div>	
<% 
session.setAttribute("id", id);
}
	
}catch(Exception e){
	e.printStackTrace();
}finally{
}
%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>