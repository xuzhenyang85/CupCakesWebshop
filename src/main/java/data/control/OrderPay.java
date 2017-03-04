package data.control;

import data.Mapper.PartMapper;
import domain.entites.PTop;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderPay", urlPatterns =
{
    "/OrderPay"
})
public class OrderPay extends HttpServlet
{

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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null)
        {
            response.sendRedirect("login.jsp");
        } else
        {
            int topid = Integer.parseInt(session.getAttribute("topid").toString());
            int bottomid = Integer.parseInt(session.getAttribute("bottomid").toString());
            int quantity = Integer.parseInt(session.getAttribute("quantity").toString());
            double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
            PartMapper pm = new PartMapper();
            boolean money = pm.enoughMoney(email, totalPrice);
            //if has enoght money
            //if (money)
            //{
                pm.addOrder(topid, bottomid, quantity, email,totalPrice);
                
                response.sendRedirect("customer.jsp");
            //}
            //else{
                response.sendRedirect("customer.jsp");
            //}
//            
//            try (PrintWriter out = response.getWriter())
//            {
//                /* TODO output your page here. You may use following sample code. */
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet NewServlet</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println(email + "topid "+topid+ " bottomid " +bottomid + " quantity "+ quantity);
//                out.println("</body>");
//                out.println("</html>");
//            }
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
