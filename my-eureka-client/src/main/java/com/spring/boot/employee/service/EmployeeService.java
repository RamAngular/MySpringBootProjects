package com.spring.boot.employee.service;

import java.util.List;

import com.spring.boot.employee.domain.Employee;


public interface EmployeeService{
	
		public List<Employee> getAllEmployees();
		public void insertEmployee(Employee e);
		public void insertEmployee(List<Employee> elist) ;
}
