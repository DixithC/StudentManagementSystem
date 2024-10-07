package com.javaproject.student_management_system;

import com.javaproject.student_management_system.entity.Student;
import com.javaproject.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	//We are implementing the commandLiner as we want to insert some values into the table
	//without having to insert it using the MySql command externally. We are using this commandLiner to insert the record
	//whenever we run the SpringBootApplication.
	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Bruce","Banner","bruceBanner@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Barry","Allen","BarryAllen@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Clark","Kent","clarkKent@yahoo.com");
//		studentRepository.save(student3);
//
//		Student student4 = new Student("Hal","Jordan","halJordan@outmail.com");
//		studentRepository.save(student4);

	}
}
