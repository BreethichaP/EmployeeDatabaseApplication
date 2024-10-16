package com.backend.employees.services;

import com.backend.employees.entities.Employees;
import com.backend.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employees> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employees getEmployeeById(Long id) { // ONLY Get the employee with the given ID
        Optional<Employees> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get(); // Got the employee we need
        }
         return null;

    }

    public List<Employees> getEmployeesByDept(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    public Employees getEmployeeByEmail(String email) {
        Optional<Employees> employee = employeeRepository.findByEmailIgnoreCase(email);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }
    public Employees addEmployee(Employees employee) {
        Employees newEmployee = employeeRepository.save(employee);
        return employee;
    }

    public Employees updateEmployee(Long id, Employees updatedValue) {
        Optional<Employees> currentEmployeeExists = employeeRepository.findById(id);
        if(currentEmployeeExists.isPresent()) {
            Employees currentEmployee = currentEmployeeExists.get();
            currentEmployee.setName(updatedValue.getName());
            currentEmployee.setEmail(updatedValue.getEmail());
            currentEmployee.setDepartment(updatedValue.getDepartment());
            employeeRepository.save(currentEmployee);
            return currentEmployee;
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        Optional<Employees> currentEmployee = employeeRepository.findById(id);
        if (currentEmployee.isPresent()) {
            Employees deleteEmployee = currentEmployee.get();
            employeeRepository.delete(deleteEmployee);
            return true;
        }
        return false;
    }

}
