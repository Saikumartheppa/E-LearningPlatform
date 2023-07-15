package com.saikumar.ELearningPlatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;

    private String bookDescription;
    private Integer bookPrice;
    @ManyToOne
    @JoinColumn(name = "fk_student_Id")
    Student student;
}
