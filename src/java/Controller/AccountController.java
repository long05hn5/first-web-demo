/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Utility.Utility;
import DAO.AccountDAO;
import Entity.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountController extends HttpServlet {

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
        doGet(request, response);
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
        String key = request.getParameter("key");
        String search = request.getParameter("Q1");
        String ageReduct = request.getParameter("ageReduce");
        String likeNguyen = request.getParameter("likeNguyen");
        String ageBetween = request.getParameter("ageBetween");
        String findEmail = request.getParameter("findEmail");
        String count = request.getParameter("count");
        String avg = request.getParameter("avg");
        AccountDAO dao = new AccountDAO();
        Utility ut = new Utility();
        List<Account> list;
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") == null) {
            response.sendRedirect("login.jsp");
        } else {
            if (key != null && !key.isEmpty()) {
                list = dao.searchByName(key);
            } else if (search != null) {
                list = dao.searchByQ1();
            } else if (ageReduct != null) {
                list = dao.getAccountByAgeReduce();
            } else if (likeNguyen != null) {
                list = dao.getAllAccountByNameLikeNguyen();
            } else if (ageBetween != null) {
                list = dao.getAccountWhichAgeBetween20and25();
            } else if (findEmail != null) {
                list = dao.getAccountByEmail();
            } else if (count != null) {
                list = dao.getAllAccount();
                request.setAttribute("value", dao.countAccount());
            } else if (avg != null) {
                list = dao.getAllAccount();
                request.setAttribute("value", dao.avgAgeAccount());
            } else {
                list = dao.getAllAccount();
            }
            request.setAttribute("listAcc", ut.mappingEntityDTO(list));
            request.setAttribute("key", key);
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
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
        doGet(request, response);
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
