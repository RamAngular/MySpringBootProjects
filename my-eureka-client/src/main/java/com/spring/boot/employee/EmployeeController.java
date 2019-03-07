package com.spring.boot.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.employee.domain.Employee;
import com.spring.boot.employee.service.EmployeeService;

@RefreshScope
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Value("${config.message: hello default}")
	private String message;
	
	@GetMapping("/hello")
	public String getMessage(){
		return message;
	}

	@RequestMapping(value = "addEmployee", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json" })
	public ResponseEntity<String> insertEmployee(@RequestBody Employee employee) {
		try {
			employeeService.insertEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body("Empolyee inserted Suceessfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empolyee inserted failed");
		}

	}
	
	@RequestMapping(value = "getAllEmployees", method = RequestMethod.GET , produces = { "application/json" })
	public List<Employee> getAllEmployee() {
			return employeeService.getAllEmployees();
	}
	

}
