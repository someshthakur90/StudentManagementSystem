package com.example.studentmanagementsystem.Controller;

import com.example.studentmanagementsystem.Entity.Student;
import com.example.studentmanagementsystem.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //handler method
    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/update/{id}")
    public String editStudentForm(@PathVariable Long id,Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model){
        if(student.getFirstName().equals("") || student.getLastName().equals("") || student.getEmail().equals("") || student.getAddress().equals(""))
            return "redirect:/students";
        Student student1 = studentService.getStudentById(id);
        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setAddress(student.getAddress());
        studentService.updateStudent(student1);
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
