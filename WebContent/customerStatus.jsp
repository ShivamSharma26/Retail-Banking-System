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
<meta charset="ISO-8859-1">
<title>Customer Status</title>
<link rel="stylesheet" href="style_table.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>
<%
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>
 <h2 align="center">Customer Status</h2>

<%
try{ 
connection = DatabaseUtil.getConnection();
String sql ="SELECT * FROM CustomerInfo";
statement=connection.prepareStatement(sql);
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
	String c_id=resultSet.getString("id") ;
	System.out.println(c_id);
%> 
<input type="hidden" name="id" value=<%=resultSet.getInt("id")%> />
<table class="content-table">
<thead>
<tr>
<th>Customer Id</th>
<th>Customer SSNID</th>
<th>Status</th>  
<th>Message</th>
<th>Last Updated</th>
<th>Operations</th>
<th>View Profile</th>
</tr>
</thead>
<tbody>
<tr>
<td><%=resultSet.getInt("id")%></td> <!-- fetching customer id -->
<td><%=resultSet.getInt("ssnid")%></td> <!-- fetching customer ssnid -->
<td><%=resultSet.getString("status")%></td> <!-- fetching customer status -->
<td><%=resultSet.getString("message") %></td> <!-- fetching customer status Message -->
<td><%=resultSet.getTimestamp("timeStamp_data") %></td> <!-- fetching customer last updated date -->
<td><a href="customerStatus.jsp">Refresh</a></td> 
<td><a href="viewProfile.jsp?id=<%=resultSet.getInt("id")%>">View Profile</a></td>
</tr>
</tbody>
 

<% 
request.setAttribute("id",c_id);
}

} catch (Exception e) {
e.printStackTrace();
}
finally{
	
}
%>
</table>
<input type="hidden"name="id" value=id />
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>