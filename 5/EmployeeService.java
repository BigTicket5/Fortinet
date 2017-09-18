package com.mzz.spring.service;

import java.util.List;

import com.mzz.spring.entity.Employee;

public interface EmployeeService {
	void add(Employee employee);
	List<Employee> listEmployee();
	Employee getEmpbyName(String name);
	boolean removeEmpbyName(String name);
	int updateEmp(Employee employee);
}
