package com.EmployeeManagement.Util;

public class empResponse<T> {

	private String message;
	private boolean success;
	private T data;
//********************************************************************
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "empResponse [message=" + message + ", success=" + success + ", data=" + data + "]";
	}

	public empResponse(String message, boolean success, T data) {
		super();
		this.message = message;
		this.success = success;
		this.data = data;
	}

	public empResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
