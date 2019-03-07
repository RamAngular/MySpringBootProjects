package com.spring.boot.employee.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.employee.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	//public List<Employee> findAllEmployees();
 
}
