package com.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagement.Model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
