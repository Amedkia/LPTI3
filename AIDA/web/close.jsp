<%-- 
    Document   : close
    Created on : 29/01/2015, 11:09:22 PM
    Author     : system
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.setAttribute("usr",null);
session.setAttribute("pwd",null);
session.invalidate();

response.reset();

response.sendRedirect("./index.html");

%>