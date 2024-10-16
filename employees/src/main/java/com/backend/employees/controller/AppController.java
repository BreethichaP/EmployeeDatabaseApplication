package com.backend.employees.controller;
import com.backend.employees.entities.Employees;
import com.backend.employees.repositories.EmployeeRepository;
import com.backend.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping ("/api") // Dont need to do /api for every method
public class AppController {
    //@Autowired
   // private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> employeeList() {
       //  List<Employees> listOfEmployees = employeeRepository.findAll();
        List<Employees> listOfEmployees = employeeService.fetchAllEmployees();
        return ResponseEntity.ok(listOfEmployees);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> employee(@PathVariable Long id) {
        //Optional<Employees> employee = employeeRepository.findById(id);
       // if(employee.isPresent()) {
          Employees currentEmployee = employeeService.getEmployeeById(id);
          if(currentEmployee != null) {
              return ResponseEntity.ok(currentEmployee);
          }
        return ResponseEntity.ok("Employee does not exist");
    }

    @GetMapping("/employees/department")
    public ResponseEntity<List<Employees>> getEmployeesByDepartment(@RequestParam String department) {
      // List<Employees> listOfEmployeesByDept = employeeRepository.findByDepartmentIgnoreCase(department);
        List<Employees> listOfEmployeesByDept = employeeService.getEmployeesByDept(department);
        return ResponseEntity.ok(listOfEmployeesByDept);
    }

    @GetMapping("/employees/email")
    public ResponseEntity<?> getEmployeeInforByEmail(@RequestParam String email) {
        Employees currentEmployee = employeeService.getEmployeeByEmail(email);
        if(currentEmployee != null) {
            return ResponseEntity.ok(currentEmployee);
        }
        return ResponseEntity.ok("Employee does not exist");
    }


    @PostMapping("/employee")
    public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee) {
        Employees newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employees updatedValue) {
            Employees updatedEmployee = employeeService.updateEmployee(id,updatedValue);
            if (updatedEmployee != null) {
               return ResponseEntity.ok("Employee updated successfully");
        }
        return ResponseEntity.ok("Employee does not exist");
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
         boolean isDeleted = employeeService.deleteEmployee(id);
        if(isDeleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        }
        return ResponseEntity.ok("Employee does not exist");
    }
}
