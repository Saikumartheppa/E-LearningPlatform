package com.saikumar.ELearningPlatform.repository;

import com.saikumar.ELearningPlatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {
    Course findByCourseId(Long cId);
}
