package com.example.employ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ----------------- CREATE EMPLOYEE -----------------
    @Override
    public String createEmployee(Employee employee) {

        // DTO → Entity copy
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity); // Save to DB
        return "Save Successfully";
    }

    // ----------------- READ SINGLE EMPLOYEE -----------------
    @Override
    public Employee readEmployee(Long id) {

        EmployeeEntity entity = employeeRepository.findById(id).orElse(null);

        if (entity == null)
            return null; // not found

        Employee emp = new Employee();

        // Entity → DTO copy
        emp.setId(entity.getId());
        emp.setName(entity.getName());
        emp.setEmail(entity.getEmail());
        emp.setPhone(entity.getPhone());

        return emp;
    }

    // ----------------- READ ALL EMPLOYEES -----------------
    @Override
    public List<Employee> readEmployees() {

        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity entity : entities) {

            Employee emp = new Employee();
            emp.setId(entity.getId());
            emp.setName(entity.getName());
            emp.setEmail(entity.getEmail());
            emp.setPhone(entity.getPhone());

            employees.add(emp); // List me add
        }
        return employees;
    }

    // ----------------- DELETE EMPLOYEE -----------------
    @Override
    public boolean deleteEmployee(Long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id); // delete
            return true;
        }
        return false;
    }

    // ----------------- UPDATE EMPLOYEE -----------------
    @Override
    public String updateEmployee(Long id, Employee employee) {

        EmployeeEntity existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return "Employee Not Found";
        }

        // New data copy
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee); // update
        return "Update Successfully";
    }
}
