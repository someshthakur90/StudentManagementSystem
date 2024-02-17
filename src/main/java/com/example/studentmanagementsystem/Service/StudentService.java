package com.example.studentmanagementsystem.Service;

import com.example.studentmanagementsystem.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}
