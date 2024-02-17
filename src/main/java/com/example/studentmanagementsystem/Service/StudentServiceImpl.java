package com.example.studentmanagementsystem.Service;

import com.example.studentmanagementsystem.Entity.Student;
import com.example.studentmanagementsystem.Repo.StudentRepo;
import com.example.studentmanagementsystem.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        Student temp = studentRepo.findByEmail(student.getEmail());
        if(temp != null && temp.getEmail().equals(student.getEmail())) return temp;
        if(student.getEmail().equals("") || student.getFirstName().equals("") || student.getLastName().equals("")) return null;
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
