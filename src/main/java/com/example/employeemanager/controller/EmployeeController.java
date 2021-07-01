package com.example.employeemanager.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.entities.Employee;
import com.example.employeemanager.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Transactional
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}

	@Transactional
	@GetMapping("/findEmployeeById/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeesById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@Transactional
	@PostMapping("/add")
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
		Employee newEmployee1 = employeeService.addEmployee(employee);  
		return new ResponseEntity<>(newEmployee1, HttpStatus.OK);
	}
	
	@Transactional
	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		Employee updateEmployee1 = employeeService.UpdateEmployee(employee);  
		return new ResponseEntity<>(updateEmployee1, HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		employeeService.DeleteEmployee(id); 
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
