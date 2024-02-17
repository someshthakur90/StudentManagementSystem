package com.example.studentmanagementsystem;

import com.example.studentmanagementsystem.Entity.Student;
import com.example.studentmanagementsystem.Repo.StudentRepo;
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
	private StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student("Somesh","Thakur","somesh@gmail.com");
//		studentRepo.save(student);
	}
}
