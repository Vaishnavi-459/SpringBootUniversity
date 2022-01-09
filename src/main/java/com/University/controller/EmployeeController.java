package com.University.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.University.UniversityApplication;
import com.University.exception.ResourceNotFoundException;
import com.University.model.Employee;
import com.University.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);
	@Autowired

	private EmployeeRepository employeeRepository;

	// create get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		logger.info("getting All employees details");
		return employeeRepository.findAll();

	}

	// get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found on this id:: " + employeeId));
		logger.info("getting the employees, Id:" + employeeId);
		return ResponseEntity.ok().body(employee);
	}

	// save employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		logger.info("creating an employee");
		return employeeRepository.save(employee);
	}

	// update employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found on this id:: " + employeeId));

		employee.setEmpName(employeeDetails.getEmpName());
		employee.setEmpSalary(employeeDetails.getEmpSalary());
		employee.setEmpDoj(employeeDetails.getEmpDoj());
		employee.setEmpDob(employeeDetails.getEmpDob());
		employee.setEmpDesignation(employeeDetails.getEmpDesignation());
		employee.setEmpBonus(employeeDetails.getEmpBonus());
		employee.setAddressid(employeeDetails.getAddressid());
		employee.setEducationid(employeeDetails.getEducationid());
		employee.setExperienceid(employeeDetails.getExperienceid());

		final Employee updatedEmployee = employeeRepository.save(employee);
		logger.info("updating the employee, Id:" + employeeId);
		return ResponseEntity.ok(updatedEmployee);
	}

	// delete employee by id
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logger.info("deleting the employee, Id:" + employeeId);
		return response;
	}
}
