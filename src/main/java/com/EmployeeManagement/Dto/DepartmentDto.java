package com.EmployeeManagement.Dto;

import java.util.List;

import com.EmployeeManagement.Model.Employee;

public class DepartmentDto
{


	private String department;

	private String Location;

	private List<EmployeeDto> employees;

	public DepartmentDto() {
		super();
		this.department = department;
		Location = getLocation();
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentDto [department=" + department + ", Location=" + Location + ", employees=" + employees + "]";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	
	
}
