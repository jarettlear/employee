package com.labcorp.employee.model;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class Employee {

    private UUID id = UUID.randomUUID();
    protected double accruedVacationDays = 0;
    private double maxVacationDaysPerYear; // I was going to JsonIgnore this, but it's helpful to visualize different types of employees.
    private int totalDaysWorked;
    private static final int MAX_DAYS_WORKED_PER_YEAR = 260;


    /**
     * @param daysWorked must be greater than 0 and less than 260 as defined in MAX_DAYS_WORKED_PER_YEAR
     *                   if daysWorked + MAX_DAYS_WORKED_PER_YEAR is greater than 260 an exception is thrown
     * @return Employee
     * @throws MaxDaysException
     */
    public Employee work(int daysWorked) throws MaxDaysException {
        if (daysWorked > 0 && (daysWorked + totalDaysWorked) <= MAX_DAYS_WORKED_PER_YEAR) {
            totalDaysWorked += daysWorked;
            accruedVacationDays +=
                    (maxVacationDaysPerYear / MAX_DAYS_WORKED_PER_YEAR) * daysWorked;
            return this;
        } else {
            throw new MaxDaysException((daysWorked + totalDaysWorked) + " days is out of range for the 0 - " + MAX_DAYS_WORKED_PER_YEAR + " limit.");
        }
    }

    /**
     *
     * @param daysUsed must be greater than 0 and less than the number of accruedVacationDays.
     * @return Employee
     * @throws VacationDaysException
     */
    public Employee takeVacation(double daysUsed) throws VacationDaysException {
        if (daysUsed > 0 && daysUsed <= accruedVacationDays) {
            accruedVacationDays -= daysUsed;
            return this;
        } else {
            throw new VacationDaysException("Days Available: " +  accruedVacationDays + " Days\n Requested: " + daysUsed + " Is out of range for vacation days available." );
        }
    }
}
