/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.applicant.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.ejb.bl.ApplicantFacadeLocal;
import za.ac.tut.ejb.entities.Applicant;

/**
 *
 * @author Tshepo Mpofu
 */
public class CancelApplicationServlet extends HttpServlet {
    @EJB private ApplicantFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Applicant app = afl.find(id);
        
        afl.remove(app);
        
        RequestDispatcher disp = request.getRequestDispatcher("application_cancelled.jsp");
        disp.forward(request, response);
    }
}
