package com.labcorp.employee.service;

import com.labcorp.employee.model.Employee;
import com.labcorp.employee.model.MaxDaysException;
import com.labcorp.employee.model.VacationDaysException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final Map<UUID,Employee> employees;

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployee(UUID id) { return employees.get(id); }

    public Employee work(UUID id, int daysWorked) {
        return employees.computeIfPresent(id, (k,v) -> {
            try {
                return v.work(daysWorked);
            } catch (MaxDaysException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Employee takeVacation(UUID id, double daysUsed) {
        return employees.computeIfPresent(id, (k,v) -> {
            try {
                return v.takeVacation(daysUsed);
            } catch (VacationDaysException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
