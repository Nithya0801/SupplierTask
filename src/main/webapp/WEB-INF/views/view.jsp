<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<%@page import="java.util.*" %>
<%@page import="com.niit.Model.*" %>
<body>
<h3>
<center>
<table style="width:80%;">
<%
List<Supplier> l=(List<Supplier>)request.getSession().getAttribute("obj");
for(Supplier ll:l)
{
%>

<tr>
<td><%=ll.getSid() %></td>
<td><%=ll.getSname() %></td>
<td><a href="update?sid=<%=ll.getSid()%>">EDIT</a></td>
<td><a href="delete?sid=<%=ll.getSid()%>">DELETE</a></td>

</tr>
<%} %>

</center>
</h3>




</table>
</body>
</html>