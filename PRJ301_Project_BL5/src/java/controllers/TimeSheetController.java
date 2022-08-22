/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dal.EmployeeDBContext;
import dal.LeaveDBContext;
import helper.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import models.Employee;
import models.TimeSheet;

/**
 *
 * @author ducmi
 */
@WebServlet(name = "TimeSheetController", urlPatterns = {"/timesheet"})
public class TimeSheetController extends HttpServlet {

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
        double labourSalary = 20;
        Date today = new Date();
        today = DateTimeHelper.removeTime(today);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, -1*(dayOfMonth-1));
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1),-1);
        ArrayList<Date> dates = DateTimeHelper.getDates(begin, end);
        EmployeeDBContext empDB = new EmployeeDBContext();
        LeaveDBContext leaveDB = new LeaveDBContext();
        ArrayList<Employee> workingLst = empDB.getEmployeeWorkingDay(begin, DateTimeHelper.addDays(end,1));
        ArrayList<Employee> leaveLst = leaveDB.getEmployeeLeaveDay(begin, DateTimeHelper.addDays(end,1));
        
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i=0; i<workingLst.size();i++){
            Employee work = workingLst.get(i);
            for (int j=0;j<leaveLst.size();j++){
                if (work.getId() == leaveLst.get(j).getId()){
                    work.setLeaves(leaveLst.get(j).getLeaves());
                }
            }
            employees.add(work);
        }
        for (int i =0; i<employees.size();i++){
            for (int j=0;j<employees.get(i).getTimesheets().size();j++){
                TimeSheet ts = employees.get(i).getTimesheets().get(j);
                float hours = ts.getWorkingHours();
                ts.setLabour(hours >= 6 ? 1 : (hours <5.5 && hours > 5 ? 0.75 : 0.5));
            }
        }
        for (Employee employee : employees) {
            double salary =0;
            for (int i=0;i<employee.getTimesheets().size();i++){
                salary +=  employee.getTimesheets().get(i).getLabour() * labourSalary;
            }
            employee.setSalary(salary);
        }
        request.setAttribute("dates", dates);
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("view/report.jsp").forward(request, response);
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
