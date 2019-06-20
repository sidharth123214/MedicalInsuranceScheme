package com.cg.eis.service;
import java.util.*;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	static Map<Integer,Employee> emp=new TreeMap<Integer,Employee>();

	@Override
	public boolean addEmployee(Employee ob) {
		// TODO Auto-generated method stub
		emp.put(ob.getId(),ob);
		return true;
	}

	
	public Employee findScheme(int id) {
		// TODO Auto-generated method stub
		Employee ob=emp.get(id);
		return ob;
	}

	@Override
	public Map<Integer, Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emp;
	}


	@Override
	public String findScheme(Employee ob) {
	
		String scheme = "";
		if(ob.getSalary()>=5000.00 && ob.getSalary()<20000.00 && ob.getDesignation().equals("System Associate"))
				scheme = "Scheme C";
		else if(ob.getSalary()>=20000.00 && ob.getSalary()<40000.00 && ob.getDesignation().equals("Programmer"))
				scheme = "Scheme B";
		else if(ob.getSalary()>=40000.00 && ob.getDesignation().equals("Manager"))
				scheme = "Scheme A";
		else if(ob.getSalary()<5000.00 && ob.getDesignation().equals("Clerk"))
			scheme = "No Scheme";
		else {
			scheme="Invalid salary/designation combination...try again...";
		}
		ob.setInsuranceScheme(scheme);
		return scheme;
	}
	
}
