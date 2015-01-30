<%-- 
    Document   : menu
    Created on : 28/01/2015, 11:02:23 AM
    Author     : system
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    if (session.getAttribute("usr") == null) {
        response.sendError(403);
    }

    if (session.getAttribute("usr") != null) {
        String uss = session.getAttribute("usr").toString();
        String pwd = session.getAttribute("pwd").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function go_upload()
            {
                window.location = "subir_documento.jsp";
            }
            function go_profile_editor()
            {
                window.location = "perfil_editar.jsp";
            }
            function go_descarga_doc()
            {
                window.location = "descarga_documento.jsp";
            }
            function go_ver_doc()
            {
                window.location = "ver_doc.jsp";
            }
            function go_close()
            {
                window.location = "close.jsp";
            }
            function aviso()
            {
                alert("Recuerde que por motivos de seguridad la sesion expira tras 10 minutos de inactividad");
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.::Menu Principal::.</title>
    </head>
    <body onload="aviso()">


        <input type="button" value="Subir Documento" onclick="go_upload()">
        <input type="button" value="Editar Informacion Personal" onclick="go_profile_editor()">
        <input type="button" value="Descargar Documentos" onclick="go_descarga_doc()">
        <input type="button" value="Ver Documentos" onclick="go_ver_doc()">
        <input type="button" value="Cerrar Sesión" onclick="go_close()">

    </body>
</html>
<% }


%>
