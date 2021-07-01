package com.example.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.entities.Employee;
import com.example.employeemanager.exceptions.UserNotFoundException;
import com.example.employeemanager.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee findEmployeesById(Long id){
		return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found: " + id));
	}
	
	
	public Employee UpdateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public void DeleteEmployee(Long id){
		employeeRepository.deleteById(id);
	}

}
