package com.labcorp.employee.model;

public class SalariedEmployee extends Employee {

    public SalariedEmployee() {
        super.setMaxVacationDaysPerYear(15);
    }

    @Override
    public Employee work(int daysWorked) throws MaxDaysException {
        return super.work(daysWorked);
    }

}
