/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private Role role;
    private ArrayList<TimeSheet> timesheets = new ArrayList<>();
    private ArrayList<RequestForLeave> leaves = new ArrayList<>();
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<RequestForLeave> getLeaves() {
        return leaves;
    }
    public int getTotalLeaves()
    {
        int sum = 0;
        for (RequestForLeave leave : leaves) {
            sum+=leave.getTotalDays();
        }
        return sum;
    }

    public void setLeaves(ArrayList<RequestForLeave> leaves) {
        this.leaves = leaves;
    }
    
    
    public int getNumberOfWorkingDays()
    {
        return timesheets.size();
    }
    
    public float getNumberOfWorkingHours()
    {
        float sum = 0;
        for (TimeSheet timesheet : timesheets) {
            sum+= timesheet.getWorkingHours();
        }
        return sum;
    }
    
    public ArrayList<TimeSheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(ArrayList<TimeSheet> timesheets) {
        this.timesheets = timesheets;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
