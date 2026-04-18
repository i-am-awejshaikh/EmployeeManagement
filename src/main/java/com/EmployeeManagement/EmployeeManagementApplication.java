package com.EmployeeManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.StaticApplicationContext;

@SpringBootApplication
public class EmployeeManagementApplication {

	private final static Logger logger =LoggerFactory.getLogger(EmployeeManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
		logger.info("Alhamdulillah Rest Apis Machine Started");
		logger.info("All Good");
	}

}
