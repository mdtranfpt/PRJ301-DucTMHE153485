/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helper.DateTimeHelper;
import java.util.Date;

public class RequestForLeave {
    private int id;
    private Employee employee;
    private Date from;
    private Date to;
    private String reason; 
    private Boolean licensed;

    public Boolean getLicensed() {
        return licensed;
    }

    public void setLicensed(Boolean licensed) {
        this.licensed = licensed;
    }
    
    public int getTotalDays()
    {
        return DateTimeHelper.getDates(from, to).size();
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
       
}
