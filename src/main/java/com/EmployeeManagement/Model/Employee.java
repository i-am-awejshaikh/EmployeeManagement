
package com.EmployeeManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employyes")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@NotEmpty(message = " Name is Required ")
	@Size(min = 4, max = 20, message = " Name must be between 4 And 20 Characters ")
	private String Name;

	@Size(min = 4, max = 50, message = " Address must be between 4 And 20 Characters ")
	private String Address;

	@NotBlank(message = " Title is Required ")
	private String Title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department dept;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee(Long id,
			@NotEmpty(message = " Name is Required ") @Size(min = 4, max = 20, message = " Name must be between 4 And 20 Characters ") String name,
			@Size(min = 4, max = 50, message = " Address must be between 4 And 20 Characters ") String address,
			@NotBlank(message = " Title is Required ") String title, Department dept) {
		super();
		Id = id;
		Name = name;
		Address = address;
		Title = title;
		this.dept = dept;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Address=" + Address + ", Title=" + Title + ", dept=" + dept
				+ "]";
	}

}
