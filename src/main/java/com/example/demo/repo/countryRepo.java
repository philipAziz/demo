package com.example.demo.repo;

import com.example.demo.model.country;
import com.example.demo.model.customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("countryRepo")
public interface countryRepo extends CrudRepository<country,Long> {

}