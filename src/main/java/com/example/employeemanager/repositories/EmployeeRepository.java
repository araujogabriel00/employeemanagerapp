package com.example.employeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanager.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
