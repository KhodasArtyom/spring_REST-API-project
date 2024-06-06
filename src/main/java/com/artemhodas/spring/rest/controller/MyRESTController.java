package com.artemhodas.spring.rest.controller;

import com.artemhodas.spring.rest.entity.Employee;
import com.artemhodas.spring.rest.exception_handling.EmployeeInCorrectData;
import com.artemhodas.spring.rest.exception_handling.NoSuchEmployeeException;
import com.artemhodas.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no Employee with ID = " + id
                    + " in Database");
        } else {
            return employee;
        }
    }

    @ExceptionHandler
    private ResponseEntity<EmployeeInCorrectData> handleException(NoSuchEmployeeException exception) {
        EmployeeInCorrectData data = new EmployeeInCorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<EmployeeInCorrectData> handleException(Exception exception) {
        EmployeeInCorrectData data = new EmployeeInCorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }



}
