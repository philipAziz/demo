package com.example.demo.services;


import com.example.demo.model.employee;


import java.util.Optional;

public interface EmployeeService {
    Optional<employee> findById(int id);
}
