package com.mzz.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mzz.spring.dao.EmployeeDAO;
import com.mzz.spring.entity.Employee;

public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeDAO empdao;
	
	@Transactional
	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		empdao.add(employee);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return empdao.listEmployee();
	}

	@Transactional(readOnly = true)
	@Override
	public Employee getEmpbyName(String name) {
		// TODO Auto-generated method stub
		return empdao.getEmpbyName(name);
	}

	@Override
	public boolean removeEmpbyName(String name) {
		// TODO Auto-generated method stub
		return empdao.removeEmployeebyName(name);
	}

	@Override
	public int updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.updateEmployee(employee);
	}

}
