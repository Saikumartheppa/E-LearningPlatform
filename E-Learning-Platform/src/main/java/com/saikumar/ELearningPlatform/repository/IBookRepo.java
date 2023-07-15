package com.saikumar.ELearningPlatform.repository;

import com.saikumar.ELearningPlatform.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {

    Book findByBookId(Long bId);
}
