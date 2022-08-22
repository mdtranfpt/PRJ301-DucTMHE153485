/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.EmployeeDBContext;
import dal.LeaveDBContext;
import helper.DateTimeHelper;
import java.util.Date;

/**
 *
 * @author ducmi
 */
public class Main {
    public static void main(String[] args) {
        LeaveDBContext context = new LeaveDBContext();
        Date today = new Date();
        today = DateTimeHelper.removeTime(today);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, -1*(dayOfMonth-1));
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1),-1);
        System.out.println(context.getEmployeeLeaveDay(begin, end));
    }
}
