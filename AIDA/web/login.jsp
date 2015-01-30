<%-- 
    Document   : login
    Created on : 28/01/2015, 10:54:24 AM
    Author     : system
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

            response.sendRedirect("/AIDA/menu.jsp");

        } else {
            response.sendRedirect("./");
        }
    }


%>
