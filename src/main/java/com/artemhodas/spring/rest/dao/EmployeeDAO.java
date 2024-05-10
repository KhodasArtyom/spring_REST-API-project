package com.artemhodas.spring.rest.dao;

import com.artemhodas.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public Employee getEmployee(int id);


    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
