package com.spring.boot.employee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="employee")
@Entity
public class Employee {
	
	
	int empId;
	long salary;
	String empName;
	String empDept;
	String empAddress;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//, generator="employee_seq")
	//@SequenceGenerator(name="employee_seq", sequenceName="employee_seq", allocationSize=1)
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Column(name="salary")
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Column(name="empName")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Column(name="empDept")
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	@Column(name="empAddress")
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
