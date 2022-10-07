package com.example.demo.services;


import com.example.demo.model.employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("EmployeeService")
public class employeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo repo;

    @Override
    public Optional<employee> findById(int id) {
        return repo.findById(id);
    }
}

