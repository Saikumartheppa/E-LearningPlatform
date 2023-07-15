package com.saikumar.ELearningPlatform.controller;

import com.saikumar.ELearningPlatform.model.Course;
import com.saikumar.ELearningPlatform.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public String addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return "course Added!!!";
    }
    @GetMapping("course/{cId}")
    public Course getCourseById(@PathVariable Long cId){
        return courseService.getCourseById(cId);
    }
    @GetMapping("courses")
    public List<Course> getAllCourses(){
       return courseService.getAllCourses();
    }
    @PutMapping("course")
    public String updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @DeleteMapping("course/{cId}")
    public String deleteCourse(@PathVariable Long cId){
        return courseService.deleteCourse(cId);
    }
}
