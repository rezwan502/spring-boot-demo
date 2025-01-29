package com.example.springcore.rest;

import com.example.springcore.dao.StudentDAO;
import com.example.springcore.dao.StudentDAOImpl;
import com.example.springcore.entity.Student;
import com.example.springcore.service.StudentService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        Student student;
        student = studentService.findById(studentId);
        if (student == null ) throw new StudentNotFoundException("Id not exists");
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found");
        }
        studentService.delete(studentId);
        return "student deleted with id - " + studentId;
    }
}
