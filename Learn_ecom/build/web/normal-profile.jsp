<%-- 
    Document   : normal-profile
    Created on : Mar 30, 2019, 11:12:59 AM
    Author     : pc
--%>

<%@page import="com.ecom.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>

<%
    User user = (User) session.getAttribute("current");
    
    if (user == null) {
        response.sendRedirect("login_page.jsp");
    }
    

%>





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= user.getuName() %></h1>
        
        
        <h1><a href="LogoutServlet">Logout</a></h1>
    </body>
</html>
