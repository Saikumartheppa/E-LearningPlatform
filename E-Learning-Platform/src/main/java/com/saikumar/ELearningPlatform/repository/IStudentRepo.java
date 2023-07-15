package com.saikumar.ELearningPlatform.repository;

import com.saikumar.ELearningPlatform.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
    Student findByStudentId(Long sId);
}
