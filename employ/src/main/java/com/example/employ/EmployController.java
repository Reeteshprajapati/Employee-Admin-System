package com.example.employ;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin("http://localhost:127.0.0.1:5500")
@RestController
@RequestMapping("/employees") // Common base URL
public class EmployController {

    @Autowired
    private EmployeeService employeeService;

    // ------------------- READ ALL EMPLOYEES -------------------
    @GetMapping
    public List<Employee> getAllEmployee() {
        // Service se saare employees fetch ho rahe hain
        return employeeService.readEmployees();
    }

    // ------------------- READ SINGLE EMPLOYEE BY ID -------------------
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        // Service se ek employee return ho jayega based on ID
        return employeeService.readEmployee(id);
    }

    // ------------------- CREATE EMPLOYEE -------------------
    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        // Naya employee database me save ho jayega
        return employeeService.createEmployee(employee);
    }

    // ------------------- DELETE EMPLOYEE -------------------
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Deleted Successfully";
        } else {
            return "Deletion Failed";
        }
    }

    // ------------------- UPDATE EMPLOYEE -------------------
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        // Database me existing employee update ho jayega
        return employeeService.updateEmployee(id, employee);
    }
}
