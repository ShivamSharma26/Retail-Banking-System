<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.retailbanking.util.DatabaseUtil"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style_table.css">
<meta charset="ISO-8859-1">
<title>Account Status</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>
<%
String id = request.getParameter("userId");

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
 <h2 align="center">Account Status</h2>
<table class="content-table">
<thead>
<tr>
<th>Customer ID</th>
<th>Account ID</th>
<th>Account Type</th>
<th>Account Status</th>  
<th>Message</th>
<th>Last Updated</th>
<th>Operations</th>
</tr>
</thead>
<%
try{ 
connection = DatabaseUtil.getConnection();
statement=connection.createStatement();
String sql ="SELECT * FROM Account1";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tbody>
<tr>
<td><%=resultSet.getInt("id") %></td> <!-- fetching customer id -->
<td><%=resultSet.getInt("accid") %></td> <!-- fetching account nid -->
<td><%=resultSet.getString("acctype") %></td> <!-- fetching account type -->
<td><%=resultSet.getString("status") %></td> <!-- fetching account status -->
<td><%=resultSet.getString("message") %></td> <!-- fetching account status Message -->
<td><%=resultSet.getTimestamp("timeStamp_02") %></td> <!-- fetching account last updated date -->
<td><a href="accountStatus.jsp">Refresh</a></td> 
</tr>
</tbody> 
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
finally{
	
}
%>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>