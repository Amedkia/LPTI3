<%-- 
    Document   : login
    Created on : 29/01/2015, 10:06:39 PM
    Author     : system
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<%
String uss = request.getParameter("usr");
        String pss = request.getParameter("pwd");
        
        String uss_cryp = null;
        String pss_cryp = null;

        Crypto.cSeguridad secure = new Crypto.cSeguridad();

        try {
            uss_cryp = secure.cifrarSHA1(uss);
            pss_cryp = secure.cifrarSHA1(pss);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.toString());
        }

        String log = null;

        BD.cDatos sql = new BD.cDatos();

        try {
            sql.conectar();

            ResultSet rs = sql.consulta("call sp_login('" + uss_cryp + "','" + pss_cryp + "')");

            if (rs.next()) {

                log = rs.getString("login");
            }

            sql.cierraConexion();

        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.toString());
        }

        if (log.equals("1")) {

            session.setAttribute("usr", uss_cryp);
            session.setAttribute("pwd", pss_cryp);
            session.setMaxInactiveInterval(10*60);

            response.sendRedirect("/AIDA/menu.jsp");

        } else {
            response.sendRedirect("./");
        }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
    </body>
</html>
