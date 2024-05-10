package com.artemhodas.spring.rest.service;

import com.artemhodas.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public  Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
