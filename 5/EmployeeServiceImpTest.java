package com.mzz.spring.service;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.mzz.spring.dao.EmployeeDAO;
import com.mzz.spring.entity.Employee;



public class EmployeeServiceImpTest {
	
	 @Mock
	 EmployeeDAO dao;
	    
	 @InjectMocks
	 EmployeeServiceImp employeeService;
	    
	 @Spy
	 List<Employee> employees = new ArrayList<Employee>();
	 
	 
	 @Before
	 public void setUp(){
        MockitoAnnotations.initMocks(this);
        employees = getEmployeeList();
	 }
	 
	 @Test
	 public void saveEmployee(){
		doNothing().when(dao).add(any(Employee.class));
	    employeeService.add(any(Employee.class));
	    verify(dao, atLeastOnce()).add(any(Employee.class));
	 }
	 
	 @Test
	 public void getEmpbyName(){
		 Employee emp = employees.get(0);
		 when(dao.getEmpbyName(anyString())).thenReturn(emp);
		 Assert.assertEquals(employeeService.getEmpbyName(emp.getName()),emp);
	 }
	 
	 @Test 
	 public void getAllEmployees(){
		 when(dao.listEmployee()).thenReturn(employees);
		 Assert.assertEquals(employeeService.listEmployee(),employees);
	 }
	 
	 @Test
	 public void removeEmpbyName(){
		 when(dao.removeEmployeebyName(anyString())).thenReturn(Boolean.TRUE);
		 employeeService.removeEmpbyName(anyString());
		 verify(dao,atLeastOnce()).removeEmployeebyName(anyString());
	 }
	 
	 @Test
	 public void updateEmpAddrbyName(){
		 Employee emp = employees.get(0);
		 when(dao.getEmpbyName(anyString())).thenReturn(emp);
		 employeeService.updateEmp(emp);
		 verify(dao,atLeastOnce	()).updateEmployee(emp);
	 }
	 
	 public List<Employee> getEmployeeList(){
        Employee e1 = new Employee();
        e1.setId((long) 1);
        e1.setName("Axel");
        e1.setAddress("1075 New York Ave");
        
        Employee e2 = new Employee();
        e2.setId((long) 2);
        e2.setName("Jeremy");
        e2.setAddress("98 Central Ave");
        
        employees.add(e1);
        employees.add(e2);
        return employees;
	 } 
}
