package com.spring.boot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.employee.domain.Employee;
import com.spring.boot.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		return empList;
	}
	
	
	public void insertEmployee(Employee e) {
		employeeRepository.save(e);
	}
	
	public void insertEmployee(List<Employee> elist) {
		employeeRepository.saveAll(elist);
	}


}
