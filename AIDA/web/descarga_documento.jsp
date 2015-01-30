<%-- 
    Document   : descarga_documento
    Created on : 29/01/2015, 11:05:45 PM
    Author     : system
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("usr") == null) {
        response.sendError(403);
    }

    if (session.getAttribute("usr") != null) {
        String uss = session.getAttribute("usr").toString();
        String pwd = session.getAttribute("pwd").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%
    }%>
