package com.example.studentmanagementsystem.Repo;

import com.example.studentmanagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
}
