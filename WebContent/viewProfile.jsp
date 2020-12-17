<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.retailbanking.util.DatabaseUtil"%>
    
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style_table.css">
<meta charset="ISO-8859-1">
<title>View Profile</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sessionchecker.jsp"></jsp:include>
<%
String id = request.getParameter("id");
System.out.println("view"+id);
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<h3 align="center">Customer Profile</h3>
<table class="content-table">
<thead>
<tr>
<td>Customer Id</td>
<td>Name</td>
<td>Age</td>  
<td>Address</td>
<td>State</td>
<td>City</td>
<td>Operation</td>
</tr>
</thead>
<%
try{ 
connection = DatabaseUtil.getConnection();
statement=connection.createStatement();
int uid=Integer.parseInt(id);
String sql ="SELECT * FROM CustomerInfo where id="+uid;

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%> 
<tbody>
<tr>
<td><%=resultSet.getInt("id") %></td> <!-- fetching customer id -->
<td><%=resultSet.getString("name") %></td> <!-- fetching customer name -->
<td><%=resultSet.getInt("age") %></td> <!-- fetching customer age -->
<td><%=resultSet.getString("address") %></td> <!-- fetching customer address -->
<td><%=resultSet.getString("state") %></td> <!-- fetching customer state -->
<td><%=resultSet.getString("city") %></td>  <!-- fetching customer city -->
<td text-align="center"><a href="viewProfile.jsp">Refresh</a></td>
</tr>
<tr>
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