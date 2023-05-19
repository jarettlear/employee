package com.labcorp.employee.configuration;

import com.labcorp.employee.model.Employee;
import com.labcorp.employee.model.HourlyEmployee;
import com.labcorp.employee.model.ManagerEmployee;
import com.labcorp.employee.model.SalariedEmployee;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class EmployeeConfig {

    public Map<UUID, Employee> employees = new HashMap<>();

    @Bean
    public Map<UUID, Employee> getEmployees() {
        return employees;
    }

    @PostConstruct
    private void createEmployees() {
        for (int i = 0; i < 10; i++) {
            var hourly = new HourlyEmployee();
            var salary = new SalariedEmployee();
            var manager = new ManagerEmployee();
            employees.put(hourly.getId(), hourly);
            employees.put(salary.getId(), salary);
            employees.put(manager.getId(), manager);
        }
    }

}

