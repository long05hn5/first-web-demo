/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.TaskDAO;
import Entity.Account;
import Entity.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class TaskEditController extends HttpServlet {

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
            out.println("<title>Servlet TaskEditController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaskEditController at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        Task task = new TaskDAO().getTaskById(Integer.parseInt(id));
        if(task == null){
            response.sendRedirect("task");
            return;
        }
        request.setAttribute("task", task);
        request.getRequestDispatcher("editTask.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String progress = request.getParameter("progress");
        String updateBy = request.getParameter("updateBy");
        String updateAt = request.getParameter("updateAt");
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String mess = null;
        TaskDAO dao = new TaskDAO();
 
        Account acc = (Account)request.getSession().getAttribute("acc");
        int userId = acc.getId();
        
        Task task = new Task(Integer.parseInt(id), Float.parseFloat(progress), acc.getId(), date);
        boolean updateTask = dao.updateTask(task);
        if(updateTask){
            mess = "Update succesfull";          
        }else{
            mess = "Update failed";
        }   
        request.setAttribute("mess", mess);
        request.setAttribute("task", dao.getTaskById(Integer.parseInt(id)));
        RequestDispatcher rd = request.getRequestDispatcher("editTask.jsp");
        rd.forward(request, response);
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
