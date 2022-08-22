/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import helper.DateTimeHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Employee;
import models.Role;
import models.TimeSheet;

/**
 *
 * @author ducmi
 */
public class EmployeeDBContext extends DBContext {
    
    public ArrayList<Employee> getEmployeeWorkingDay(Date begin, Date end) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.name, r.*, ISNULL(t.tid,-1) tid,t.cin,t.cout\n"
                    + "                    FROM Employee e\n"
                    + "                    	LEFT JOIN (SELECT * FROM Timesheet WHERE \n"
                    + "                    	cin >= ?\n"
                    + "                    	AND\n"
                    + "                    	cin < ?) t \n"
                    + "                    	ON e.eid = t.eid"
                    + "                         JOIN Role r on r.rid = e.rid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setTimestamp(1, DateTimeHelper.getTimeStamp(DateTimeHelper.removeTime(begin)));
            stm.setTimestamp(2, DateTimeHelper.getTimeStamp(DateTimeHelper.removeTime(end)));
            ResultSet rs = stm.executeQuery();
            Employee curEmp = new Employee();
            Role role = new Role();
            curEmp.setId(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                if (eid != curEmp.getId()) {
                    curEmp = new Employee();
                    role = new Role();
                    curEmp.setId(eid);
                    curEmp.setName(rs.getString("name"));
                    role.setRoleId(rs.getInt("rId"));
                    role.setName(rs.getString("rname"));
                    role.setRate(rs.getFloat("salaryRate"));
                    curEmp.setRole(role);
                    employees.add(curEmp);
                }
                int tid = rs.getInt("tid");
                if (tid != -1) {
                    TimeSheet t = new TimeSheet();
                    t.setEmployee(curEmp);
                    t.setId(tid);
                    t.setCheckin(DateTimeHelper.getDateFrom(rs.getTimestamp("cin")));
                    t.setCheckout(DateTimeHelper.getDateFrom(rs.getTimestamp("cout")));
                    curEmp.getTimesheets().add(t);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return employees;
    }
}
