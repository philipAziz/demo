package com.example.demo.repo;

import com.example.demo.model.vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepo extends JpaRepository<vacation, Integer> {
}