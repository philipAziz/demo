package com.example.demo.services;

import com.example.demo.model.customer;
import com.example.demo.model.customerDTO;

import java.util.List;
import java.util.Optional;

public interface customerService   {
    Iterable<customer> findAll();
    List<customerDTO> getCustomers(Optional<Long> countryId, Optional<Boolean> valid);
//    List<customer> getValidCustomers(boolean valid);
    boolean validate(String countryPattern,String phone);
    List<customer> findByCountry(Long countryId);
//   List<customer> findByState(String state);
    customerDTO entityToDto(customer cust);
}
