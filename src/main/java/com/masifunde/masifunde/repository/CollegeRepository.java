package com.masifunde.masifunde.repository;

import com.masifunde.masifunde.models.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepository extends JpaRepository <College, Integer> {
    List<College> findByName(String name);
    List<College> findByDescription(String description);
}
