package com.example.demo.repo;

import com.example.demo.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<employee, Integer> {
}