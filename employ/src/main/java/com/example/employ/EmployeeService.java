package com.example.employ;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee); // Create Employee

    Employee readEmployee(Long id); // Read single employee

    List<Employee> readEmployees(); // Read all employees

    boolean deleteEmployee(Long id); // Delete employee

    String updateEmployee(Long id, Employee employee); // Update employee
}
