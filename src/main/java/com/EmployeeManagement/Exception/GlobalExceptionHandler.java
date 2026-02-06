package com.EmployeeManagement.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.EmployeeManagement.Util.empResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*1
	 * @ExceptionHandler(EmployeeNotFoundException.class) public
	 * ResponseEntity<String> handlingException(EmployeeNotFoundException
	 * employeeNotFoundException) { return new
	 * ResponseEntity<>(employeeNotFoundException.getMessage(),
	 * HttpStatus.NOT_FOUND); }
	 */

	/*2
	 * @ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, Object>> EmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException)
	{
		Map<String,Object> response = new HashMap<String,Object>();

		response.put("Message", employeeNotFoundException.getMessage());
		response.put("Status", HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(response);

		//return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		*/
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity <empResponse<Object>>EmployeeNotFoundException
	(EmployeeNotFoundException employeeNotFoundException)
	{
		empResponse <Object> EmpResponse=new empResponse<>();
		EmpResponse.setData(employeeNotFoundException.getMessage());//String also Object that why we use Object 
		EmpResponse.setMessage("Employee Not Found");
		EmpResponse.setSuccess(false);
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(EmpResponse);
	
	}
	
	
	//Handling MethodArgumentNotValidException
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		HashMap <String,String>response=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->
		{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			response.put(fieldName, message);
		});
		
		return ResponseEntity.badRequest().body(response);
	}
	
	
	
	
	
	
	
	

}
