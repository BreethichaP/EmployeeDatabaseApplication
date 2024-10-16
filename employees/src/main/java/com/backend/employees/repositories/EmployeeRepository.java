package com.backend.employees.repositories;

import com.backend.employees.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    // Search for JPA methods
    // findByEmail and change department, instead of using findById
    public List<Employees> findByDepartmentIgnoreCase(String department); // Need to make a method to get a list of employees by dept like findById()
    public Optional<Employees> findByEmailIgnoreCase (String email);
}
