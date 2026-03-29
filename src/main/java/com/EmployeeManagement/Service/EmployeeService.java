package com.EmployeeManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EmployeeManagement.Dto.DepartmentDto;
import com.EmployeeManagement.Dto.EmployeeDto;
import com.EmployeeManagement.Exception.EmployeeNotFoundException;
import com.EmployeeManagement.Model.Department;
import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Repository.DepartmentRepo;
import com.EmployeeManagement.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepo departmentRepo;

	// DtoToEntity
	public Employee DtoToEntity(EmployeeDto employeeDto) {

		Employee emp = new Employee();
		emp.setName(employeeDto.getName());
		emp.setTitle(employeeDto.getTitle());
		emp.setAddress(employeeDto.getAddress());

		Department dept = departmentRepo.findById(employeeDto.getDepartmentDto()).orElseThrow();
		emp.setDept(dept);
		return emp;
	}

	// Dto to Entity
	public Employee dtoToEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setAddress(employeeDto.getAddress());
		employee.setName(employeeDto.getName());
		employee.setTitle(employeeDto.getTitle());
		return employee;
	}

	/*
	 * // Entity to dto public EmployeeDto EntityToDto(Employee emp) {
	 * 
	 * EmployeeDto employeeDto = new EmployeeDto();
	 * employeeDto.setAddress(emp.getAddress()); employeeDto.setName(emp.getName());
	 * employeeDto.setTitle(emp.getTitle()); }
	 */
	
	
	/*
	 * public EmployeeDto save(EmployeeDto employeeDto) {
	 * 
	 * Employee emp = this.dtoToEntity(employeeDto); Employee employee =
	 * employeeRepository.save(emp);
	 * }
	 */

	

	// 1.Save
	public Employee saveTheEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	// 2.FetchAll
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

	// 3. fetch by Id
	public Employee fetchById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found of id " + id));

	}
	
	// 4.update Employee
	public Employee update(Long id, Employee emp) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not found of id " + id));

		existingEmployee.setName(emp.getName());
		existingEmployee.setAddress(emp.getAddress());
		existingEmployee.setTitle(emp.getTitle());

		return employeeRepository.save(existingEmployee);
	}

	// 5.Delete
	public Employee deleteById(Long id) { 
	    Employee empForDelete = employeeRepository.findById(id)
	        .orElseThrow(() -> new EmployeeNotFoundException("Employee Not found of id " + id));

	    employeeRepository.deleteById(id);

	    return empForDelete;
	}
}