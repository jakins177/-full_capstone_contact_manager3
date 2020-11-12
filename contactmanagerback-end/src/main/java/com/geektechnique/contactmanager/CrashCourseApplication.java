package com.geektechnique.contactmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geektechnique.contactmanager.model.PersonDataBase;

@SpringBootApplication
public class CrashCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrashCourseApplication.class, args);
		
		PersonDataBase DB = new PersonDataBase();
		

	}

}
