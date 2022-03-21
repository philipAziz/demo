package com.example.demo.controllers;

import com.example.demo.model.customer;
import com.example.demo.model.customerDTO;
import com.example.demo.services.countryService;
import com.example.demo.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
public class customerController {
    @Autowired
    customerService customerService;
    @Autowired
    countryService countryService;
    @RequestMapping({"/Customers"})
    public List<customerDTO>getCustomers(@RequestParam Optional<Long> countryId, Optional<Boolean> valid) {
        return customerService.getCustomers(countryId,valid);
    }

    @RequestMapping({"/validate"})
    public boolean validate(String countryCode, String phone) {
        return customerService.validate(countryCode,phone);
    }


}
