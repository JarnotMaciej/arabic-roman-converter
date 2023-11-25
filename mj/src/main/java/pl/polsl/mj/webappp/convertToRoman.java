package pl.polsl.mj.webappp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import static java.lang.System.out;

import pl.polsl.mj.model.Model;

/**
 * Servlet class, responsible for converting arabic numbers to roman.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
@WebServlet(urlPatterns = { "/convertToRoman" })
public class convertToRoman extends HttpServlet {
    Model model = new Model();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Convert to Roman</title>");
        out.println("</head>");
        out.println("<body>");

        String arabic = request.getParameter("arabic");
        PrintWriter out = response.getWriter();
        if (arabic == null || !model.validateArabic(arabic)) {
            out.println("<h1>Error!</h1>");
        } else {
            try {
                String roman = model.arabicToRoman(Integer.parseInt(arabic));

                out.println("<h1>Successfully converted to Roman!</h1>");
                out.println("<h2>Arabic: " + arabic + "</h2>");
                out.println("<h2>Roman: " + roman + "</h2>");
            } catch (Exception e) {
                out.println("<h1>Error: Invalid Arabic numeral!</h1>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
