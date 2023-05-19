package com.labcorp.employee.controller;

import com.labcorp.employee.model.Employee;
import com.labcorp.employee.model.VacationDays;
import com.labcorp.employee.model.WorkDays;
import com.labcorp.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        var employees = employeeService.getEmployees();

        if (CollectionUtils.isEmpty(employees))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID id) {
        var employee = employeeService.getEmployee(id);

        if (employee == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employee);
    }


    @PutMapping("{id}/add-work-days")
    public ResponseEntity<Employee> addWorkDays(@PathVariable UUID id, @RequestBody WorkDays days) {
        var employee = employeeService.work(id, days.number());

        if (employee == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employee);

    }

    @PutMapping("{id}/use-vacation-days")
    public ResponseEntity<Employee> useVacationDays(@PathVariable UUID id, @RequestBody VacationDays days) {
        var employee = employeeService.takeVacation(id, days.number());

        if (employee == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(employee);
    }
}