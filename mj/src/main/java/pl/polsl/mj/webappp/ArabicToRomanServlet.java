package pl.polsl.mj.webappp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

import pl.polsl.mj.manager.DatabaseConnector;
import pl.polsl.mj.model.*;

/**
 * Servlet class, responsible for converting arabic numbers to roman.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.5
 */
@WebServlet(urlPatterns = { "/convertToRoman" })
public class ArabicToRomanServlet extends HttpServlet {
    /**
     * Model object, responsible for converting arabic numbers to roman.
     */
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

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\" data-bs-theme=\"dark\">");
        out.println("<head>");
        out.println("<title>Arabic - Roman converter | Conversion</title>");
        out.println("<link rel=\"icon\" href=\"favicon.png\" type=\"image/x-icon\"/>");
        out.println("<link href=\"bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");

        String arabic = request.getParameter("arabic");

        if (arabic == null || !model.validateArabic(arabic)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Arabic numeral! Number must be between 1 and 3999!");
        } else {
            try {
                String roman = model.arabicToRoman(Integer.parseInt(arabic));

                out.println("<h1 class=\"mt-3\">Successfully converted to Roman!</h1>");
                out.println("<h2>Arabic: " + arabic + "</h2>");
                out.println("<h2>Roman: " + roman + "</h2>");

                try {
                    Connection con = DatabaseConnector.getConnection();

                    try (Statement statement = con.createStatement()) {
                        statement.executeUpdate("INSERT INTO ConversionData VALUES ('Arabic to Roman', '" + arabic
                                + "', '" + roman + "', CURRENT_TIMESTAMP)");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } catch (Exception e) {
                    out.println("<h1 class=\"mt-3\">Error!</h1>");
                }
            } catch (Exception e) {
                out.println("<h1 class=\"mt-3\">Error!</h1>");
            }
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
