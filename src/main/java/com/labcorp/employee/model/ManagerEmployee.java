package com.labcorp.employee.model;

public class ManagerEmployee extends Employee {

    public ManagerEmployee() {
        super.setMaxVacationDaysPerYear(30);
    }

    @Override
    public Employee work(int daysWorked) throws MaxDaysException { return super.work(daysWorked); }

}
