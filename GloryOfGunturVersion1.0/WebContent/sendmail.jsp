<%@page import="com.google.mail.Send"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>mail sent</title>
</head>
<body>
<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String message=request.getParameter("txt");
Send.sendMail(name, email, message);
response.sendRedirect("index.html?status=mail sent");
%>


</body>
</html>