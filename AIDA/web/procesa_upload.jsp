<%-- 
    Document   : procesa_upload
    Created on : 30/01/2015, 12:15:14 AM
    Author     : system
--%>

<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    if (session.getAttribute("usr") == null) {
        response.sendError(403);
    }

    if (session.getAttribute("usr") != null) {
String name = null;
//String ubicacionArchivo = "/home/system/NetBeansProjects/LPTI3/AIDA/web/files"; //para la casa
String ubicacionArchivo = "C://Users/Alumno/Documents/NetBeansProjects/LPTI3/AIDA/web/files"; //para la escuela
            //Esta ruta se debe de cambiar a donde este la carpeta profile_images del pryecto, es ideal si esta en un servidor ya que la ruta seria fija
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            factory.setRepository(new File(ubicacionArchivo));

            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> partes = upload.parseRequest(request);

                for (FileItem item : partes) {
                    File file = new File(ubicacionArchivo, item.getName());
                    item.write(file);
                    name = item.getName();
                }
                ;
                out.print("<script>alert('El archivo se subio correctamente');</script>");
                
            } catch (FileUploadException ex) {
                out.write("Error al subir archivo " + ex.getMessage());
            }
    }
            
    
%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function go()
            {
                
                window.location = "menu.jsp";
            }
            function og()
            {
                setTimeout(go(),10000);
            }
          
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notificación</title>
        
    </head>
    <body onload="og()">
        
        
       
    </body>
</html>
