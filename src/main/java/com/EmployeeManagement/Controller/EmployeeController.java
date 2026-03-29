package com.EmployeeManagement.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.Model.Employee;
import com.EmployeeManagement.Service.EmployeeService;
import com.EmployeeManagement.Util.empResponse;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//1.save
	@PostMapping("/save")
	public ResponseEntity<Employee> saveTheEmployee(@Valid @RequestBody Employee emp) {
		if (emp.getName() == null) {

			return ResponseEntity.badRequest().build();
		}
		Employee SaveEmp = employeeService.saveTheEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(SaveEmp);
	}

	// 2.GetAllData
	@GetMapping("/getAllData")
	public ResponseEntity<List<Employee>> fetchAllData() {
		List<Employee> allEmployee = employeeService.fetchAllEmployee();
		if (allEmployee.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(allEmployee);
	}

	// 3.getById
	@GetMapping("/getById/{id}")
	public ResponseEntity<empResponse<Employee>> getById(@PathVariable("id") Long id) {

		/*
		 * Optional<Employee> emp=employeeService.fetchById(id); if(emp.isEmpty()) {
		 * return ResponseEntity.notFound().build(); } Employee empGet=emp.get(); return
		 * ResponseEntity.ok(empGet);
		 */
	Employee empFound = employeeService.fetchById(id);
	
		/*HashMap <String ,Object> response=new HashMap<String,Object>();
		response.put(" Data Of Employee Id is : ", empFound.getId());
		response.put(" Status ", HttpStatus.OK.value());
		response.put(" Data ", empFound);
		response.put(" TimeStamp ", LocalDateTime.now());
		return response;
		
		*/
		
		empResponse <Employee> EmpResponse=new empResponse<>();
		EmpResponse.setData(empFound);
		EmpResponse.setMessage("Data Of Employee Id is " +empFound.getId());
		EmpResponse.setSuccess(true);
           return  ResponseEntity.ok(EmpResponse);
	}

	// 4.Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateUser(@PathVariable("id") Long id, @RequestBody Employee emp) {
		Employee updatedEmp = employeeService.update(id, emp);
		return ResponseEntity.ok(updatedEmp);

	}

	// 5.Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id) {
		Employee deletedEmp = employeeService.deleteById(id);
		return ResponseEntity.ok(deletedEmp);
		/*
		 * if(deletedEmp != null) { return ResponseEntity.ok(deletedEmp); // 200 OK +
		 * deleted employee } else { return ResponseEntity.notFound().build(); // 404
		 * Not Found }
		 */
	}

}
