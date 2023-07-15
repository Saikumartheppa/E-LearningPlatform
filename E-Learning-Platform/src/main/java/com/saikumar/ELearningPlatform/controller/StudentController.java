package com.saikumar.ELearningPlatform.controller;

import com.saikumar.ELearningPlatform.model.Student;
import com.saikumar.ELearningPlatform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student/{sId}")
    public Student getStudentById(@PathVariable Long sId){
        return studentService.getStudentById(sId);
    }
    @PutMapping("student")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
    @DeleteMapping("student/{sId}")
    public String removeStudent(@PathVariable Long sId){
        return studentService.removeStudent(sId);
    }
}
