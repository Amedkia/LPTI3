/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author system
 */
@WebServlet(name = "aprueba", urlPatterns = {"/aprueba"})
public class aprueba extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String uss = request.getParameter("usr");
           
            String uss_cryp = null;
           

            Crypto.cSeguridad secure = new Crypto.cSeguridad();

            try {
                uss_cryp = secure.cifrarSHA1(uss);
               
            } catch (NoSuchAlgorithmException ex) {
                System.out.println(ex.toString());
            }
            BD.cDatos sql = new BD.cDatos();
            
          
            
             try {
                sql.conectar();

                ResultSet rs = sql.consulta("call sp_aprobar('" + uss_cryp + "')");

                if (rs.next()) {
                    out.print("<link href=\"CSS/base.css\" rel=\"stylesheet\" type=\"text/css\"/>");

                  out.print("<h1>"+rs.getString("login")+"<h1>");
                  
                    response.sendRedirect("./");
                }

                sql.cierraConexion();

            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex.toString());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
