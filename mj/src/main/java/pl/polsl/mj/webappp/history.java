/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.mj.webappp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pl.polsl.mj.model.ConversionData;

/**
 * Servlet class, responsible for displaying history of conversions.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
@WebServlet(name = "history", urlPatterns = { "/history" })
public class history extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        List<ConversionData> conversions = (List<ConversionData>) session.getAttribute("conversions");
        if (conversions == null) {
            conversions = new java.util.ArrayList<>();
            session.setAttribute("conversions", conversions);
        }
        // setting cookie -> how many visits user has made
        Cookie[] cookies = request.getCookies();
        Cookie visitCount = new Cookie("visits", "1");
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if ("visits".equals(c.getName())) {
                    int count = Integer.parseInt(c.getValue());
                    count++;
                    visitCount = new Cookie("visits", Integer.toString(count));
                }
            }
        }
        response.addCookie(visitCount);

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\" data-bs-theme=\"dark\">");
        out.println("<head>");
        out.println("<title>Convert to Roman</title>");
        out.println("<link href=\"bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");

        out.println("<h1 class=\"mt-3\">History</h1>");
        out.println("<table class=\"table table-striped table-hover\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th scope=\"col\">Conversion type</th>");
        out.println("<th scope=\"col\">Input</th>");
        out.println("<th scope=\"col\">Result</th>");
        out.println("<th scope=\"col\">Date</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        if (conversions.isEmpty()) {
            out.println("<tr>");
            out.println("<td colspan=\"4\">No conversions yet.</td>");
            out.println("</tr>");
        } else {
            for (ConversionData conversion : conversions) {
                out.println("<tr>");
                out.println("<td>" + conversion.getConversionType() + "</td>");
                out.println("<td>" + conversion.getInput() + "</td>");
                out.println("<td>" + conversion.getResult() + "</td>");
                out.println("<td>" + conversion.getDate() + "</td>");
                out.println("</tr>");
            }
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<h2 class=\"m-3\">Number of visits on history page: " + visitCount.getValue() + "</h2>");
        out.println("<hr><a href=\"index.html\" class=\"btn btn-warning m-3\">Back</a>");
        out.println("</div>");
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
