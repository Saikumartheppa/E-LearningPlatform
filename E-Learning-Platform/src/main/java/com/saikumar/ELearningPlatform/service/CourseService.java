package com.saikumar.ELearningPlatform.service;

import com.saikumar.ELearningPlatform.model.Course;
import com.saikumar.ELearningPlatform.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public Course getCourseById(Long cId) {
        return courseRepo.findByCourseId(cId);
    }

    public List<Course> getAllCourses() {
       return  courseRepo.findAll();
    }

    public String updateCourse(Course course) {
        if(courseRepo.existsById(course.getCourseId())){
            courseRepo.save(course);
          return  " course updated";
        }else{
            return "invalid credentials";
        }
    }

    public String deleteCourse(Long cId) {
        if(courseRepo.existsById(cId)) {
            courseRepo.deleteById(cId);
            return "course deleted!!!";
        }else{
            return "invalid credentials";
        }
    }
}
