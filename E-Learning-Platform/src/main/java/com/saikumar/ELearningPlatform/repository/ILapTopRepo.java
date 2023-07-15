package com.saikumar.ELearningPlatform.repository;

import com.saikumar.ELearningPlatform.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILapTopRepo extends JpaRepository<Laptop,Long> {
    Laptop findByLaptopId(Long laptopId);
}
