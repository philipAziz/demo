package com.example.demo.controllers;

import com.example.demo.model.employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
public class employeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Optional<employee> getEmployee() {
        return employeeService.findById(1);
    }


}
