/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

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
           
            String opcion = request.getParameter("op");

            if (opcion != null) {

                switch (opcion) {
                    case "1":
                        URL url2 = new URL("http://www.easysoft.esy.es/");
                        BufferedReader in2 = new BufferedReader(
                                new InputStreamReader(url2.openStream()));

                        String inputLine2;
                        while ((inputLine2 = in2.readLine()) != null) {
                            out.println(inputLine2);
                            System.out.println(inputLine2);
                        }
                        in2.close();
                        break;

                    case "2":
                        out.println("Mandar a otro fucking servlet");

                        break;

                    case "3":

                        URL url = new URL("https://www.facebook.com/");
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(url.openStream()));

                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            out.println(inputLine);
                        }
                        in.close();
                        break;
                }

            } else {
                out.println("Nada que ver aqui Bitches :3");
                //response.sendRedirect("http://localhost:8084/OtroServlet/servlet?op=1");
                //response.sendRedirect("http://192.168.1.149:8080/ServletXml/otroServlet");
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
