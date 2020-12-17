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
String accid=request.getParameter("accId");
System.out.println("aghasbah"+accid);
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String query=null;

%>
<div class="center">
<form action="AccountController" method="post">
<h3>Delete Account</h3>
<table>
<tr><td>Account Id</td>
<td>
<input type="text" name ="Account Id" readonly value="<%=request.getParameter("accId") %>"/></td></tr>
<% 
try{
	con = DatabaseUtil.getConnection();
	System.out.println(con);
		query="select * from Account1 where accid=?";
		ps=con.prepareStatement(query);
		ps.setString(1,accid);
		rs=ps.executeQuery();
	while(rs.next()){
		System.out.println(rs.getString("acctype"));
%>
<tr>
<td>Account Type</td>
<td><input type="text" name="Account Type" disabled value="<%=rs.getString("acctype")%> "/></td>
</tr>
<% }
}catch(Exception e){
	e.printStackTrace();
}finally{
	
}
%>
<tr>
<td><input type="hidden" name="action" value="deleteData"></td>
<td><input type="submit" name="Delete" value="Delete" />
</td>
</tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>