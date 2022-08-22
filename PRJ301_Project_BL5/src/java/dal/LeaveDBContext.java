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
import models.RequestForLeave;
import models.Role;

/**
 *
 * @author ducmi
 */
public class LeaveDBContext extends DBContext{
    public ArrayList<Employee> getEmployeeLeaveDay(Date begin, Date end) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.name, e.rid, r.*, ISNULL(l.lid,-1) lid, l.[from], l.[to], l.[reason], l.licensed \n"
                    + "                    FROM Employee e\n"
                    + "                    	LEFT JOIN (SELECT * FROM Leave WHERE \n"
                    + "                         [from] >= ?\n"
                    + "                    	AND\n"
                    + "                    	[to] < ?) l \n"
                    + "                    	ON e.eid = l.eid"
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
                    role.setRoleId(rs.getInt("rid"));
                    role.setName(rs.getString("rname"));
                    role.setRate(rs.getFloat("salaryRate"));
                    curEmp.setRole(role);
                    employees.add(curEmp);
                }
                int lid = rs.getInt("lid");
                if (lid != -1) {
                    RequestForLeave l = new RequestForLeave();
                    l.setEmployee(curEmp);
                    l.setId(lid);
                    l.setReason(rs.getString("reason"));
                    l.setFrom(DateTimeHelper.getDateFrom(rs.getTimestamp("from")));
                    l.setTo(DateTimeHelper.getDateFrom(rs.getTimestamp("to")));
                    l.setLicensed(rs.getBoolean("licensed"));
                    curEmp.getLeaves().add(l);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
}
