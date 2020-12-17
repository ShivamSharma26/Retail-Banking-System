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
String custid=request.getAttribute("customerId").toString();
System.out.println("get"+custid);
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String query=null;%>
<div class="center">
<form action="confirmDeleteAccount.jsp" method="post">
<table>
<% %>
<tr><td>Select Account Id</td>
<td>
<select name="accId" width="250px">
<option value="-1" >Select Account Id</option> 
<% 
try{
	con = DatabaseUtil.getConnection();
	System.out.println(con);
		query="select * from Account1 where id=?";
		ps=con.prepareStatement(query);
		ps.setString(1,custid);
		rs=ps.executeQuery();
	while(rs.next()){
		System.out.println(rs.getInt("accid"));
%>


<option value="<%=rs.getInt("accid")%>"><%=rs.getInt("accid")%></option>

<%
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	
}
%>
</select>

</td>
</tr>
<tr><td>
<td>
<input type="submit" value="submit"></td></tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>