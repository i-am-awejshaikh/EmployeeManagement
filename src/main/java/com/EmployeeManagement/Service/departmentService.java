package com.EmployeeManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.Dto.DepartmentDto;
import com.EmployeeManagement.Dto.EmployeeDto;
import com.EmployeeManagement.Model.Department;
import com.EmployeeManagement.Repository.DepartmentRepo;

@Service
public class departmentService {
	@Autowired
	private DepartmentRepo departmentRepo;

	// DTO to ENTITY
	public Department dtoToEntity(DepartmentDto departmentDto) {

		Department dept = new Department();
		dept.setDepartment(departmentDto.getDepartment());
		dept.setLocation(departmentDto.getLocation());

		return dept;
	}
	// ENTITY to DTO

	public DepartmentDto EntityToDto(Department department) {

		DepartmentDto departmentDto = new DepartmentDto();

		departmentDto.setDepartment(department.getDepartment());
		departmentDto.setLocation(department.getLocation());

		List<EmployeeDto> emoloyeeDtoList = new ArrayList();

		department.getEmployees().forEach(emp -> {

			EmployeeDto employeeDto = new EmployeeDto();

			employeeDto.setAddress(emp.getAddress());
			employeeDto.setName(emp.getName());
			employeeDto.setTitle(emp.getTitle());

			emoloyeeDtoList.add(employeeDto);

		});
		return departmentDto;
	}

//save

	public DepartmentDto saveDept(DepartmentDto departmentDto) {
		Department dept = this.dtoToEntity(departmentDto);
		Department dept2 = departmentRepo.save(dept);
		DepartmentDto deptDto = this.EntityToDto(dept2);

		return deptDto;
	}

	// getById

	public DepartmentDto getByDeptId(Long id) {

		Department department = departmentRepo.findById(id).orElseThrow();
		DepartmentDto deptDto = this.EntityToDto(department);

		return deptDto;
	}

	// findAll

	public List<DepartmentDto> getAll() {

		List<Department> departmentList = departmentRepo.findAll();

		List<DepartmentDto> deptList = new ArrayList<>();

		departmentList.forEach(dept -> {
			DepartmentDto deptDto = this.EntityToDto(dept);

			deptList.add(deptDto);

		});

		return deptList;
	}
}
