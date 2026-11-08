/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DTO.AccountDTO;
import DTO.AccountException;
import DTO.UpdateAccount;
import Entity.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class AccountEditController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductEditController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        AccountDAO dao = new AccountDAO();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") == null) {
            response.sendRedirect("login.jsp");
        } else {
            Account acc = dao.getAccountById(Integer.parseInt(id));
            request.setAttribute("acc", acc);
            RequestDispatcher rd;
            if (id == null || id == "") {
                rd = request.getRequestDispatcher("account");
            } else {
                rd = request.getRequestDispatcher("edit.jsp");
            }
            rd.forward(request, response);
        }

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

        AccountDAO dao = new AccountDAO();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String mess = "";
        AccountDTO dto = new AccountDTO(Integer.parseInt(id), address, name, age, address, email, phoneNumber, password);
        AccountException exp = new AccountException(dto);
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") == null) {
            response.sendRedirect("login.jsp");
        } else {
            try {
                if (password == "" || password == null) {
                    password = dao.getAccountById(Integer.parseInt(id)).getPassword();
                }
                if (exp.isValid()) {
                    UpdateAccount acc = new UpdateAccount(Integer.parseInt(id), name, Integer.parseInt(age), address, email, phoneNumber, password);
                    dao.updateAccount(acc);
                    mess = "Update Succesfull";
                }
            } catch (NumberFormatException e) {
                System.out.println("checkUpdate" + e.getMessage());
            }
            request.setAttribute("mess", mess);
            request.setAttribute("exp", exp);
            request.setAttribute("acc", dto);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }

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
