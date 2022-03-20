package com.example.demo.services;

import com.example.demo.model.country;
import com.example.demo.model.customer;

import java.util.Optional;

public interface countryService {
    Optional<country> findById(Long id);
}
