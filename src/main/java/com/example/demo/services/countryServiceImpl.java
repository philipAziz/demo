package com.example.demo.services;


import com.example.demo.model.country;
import com.example.demo.repo.countryRepo;
import com.example.demo.repo.customerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("countryService")
public class countryServiceImpl implements countryService{
@Autowired
    countryRepo repo;

    public Optional<country> findById(Long id) {
        return repo.findById(id);
    }

    }

