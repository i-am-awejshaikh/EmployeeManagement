package com.EmployeeManagement.Dto;

public class EmployeeDto {

	private String Name;
	private String Address;
	private String Title;
	private Long departmentDtoId;

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

	public Long getDepartmentDto() {
		return departmentDtoId;
	}

	public void setDepartmentDto(Long departmentDto) {
		this.departmentDtoId = departmentDto;
	}

	@Override
	public String toString() {
		return "EmployeeDto [Name=" + Name + ", Address=" + Address + ", Title=" + Title + ", departmentDto="
				+ departmentDtoId + "]";
	}

	public EmployeeDto(String name, String address, String title, Long departmentDto) {
		super();
		Name = name;
		Address = address;
		Title = title;
		this.departmentDtoId = departmentDto;
	}

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
