<%-- 
    Document   : index
    Created on : 10/01/2015, 07:12:29 PM
    Author     : system
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>    <%-- start web service invocation --%><hr/>
    <%
    try {
	services.Imagenes_Service service = new services.Imagenes_Service();
	services.Imagenes port = service.getImagenesPort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = request.getParameter("usr");
        
	java.lang.String password = request.getParameter("pwd");
	// TODO process result here
	java.lang.String result = port.datos(name, password);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
