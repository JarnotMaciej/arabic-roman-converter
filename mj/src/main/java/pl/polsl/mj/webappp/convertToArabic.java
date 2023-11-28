package pl.polsl.mj.webappp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import pl.polsl.mj.model.*;

/**
 * Servlet class, responsible for converting roman numbers to arabic.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
@WebServlet(urlPatterns = { "/convertToArabic" })
public class convertToArabic extends HttpServlet {
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        List<ConversionData> conversions = (List<ConversionData>) session.getAttribute("conversions");
        if (conversions == null) {
            conversions = new java.util.ArrayList<>();
            session.setAttribute("conversions", conversions);
        }

        String roman = request.getParameter("roman");
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\" data-bs-theme=\"dark\">");
        out.println("<head>");
        out.println("<title>Convert to Arabic</title>");
        out.println("<link href=\"bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");

        if (roman == null || !model.validateRoman(roman)) {
            response.sendError(response.SC_BAD_REQUEST, "Invalid Roman numeral! Number must be between I and MMMCMXCIX!");
        } else {
            int arabic = model.romanToArabic(roman);
            out.println("<h1 class=\"mt-3\">Successfully converted to Arabic!</h1>");
            out.println("<h2>Roman: " + roman + "</h2>");
            out.println("<h2>Arabic: " + arabic + "</h2>");
            conversions.add(new ConversionData("Roman to Arabic", roman, Integer.toString(arabic), new java.util.Date()));
            session.setAttribute("conversions", conversions);
        }
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
