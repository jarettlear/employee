package com.labcorp.employee.model;


public class HourlyEmployee extends Employee {

    public HourlyEmployee() {
        super.setMaxVacationDaysPerYear(10);
    }

    @Override
    public Employee work(int daysWorked) throws MaxDaysException {
        return super.work(daysWorked);
    }

}
