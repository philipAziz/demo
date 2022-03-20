package com.example.demo.repo;

import com.example.demo.model.customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerRepo")
public interface customerRepo extends CrudRepository<customer,Long> {

    List<customer>findAllByContId(Long countryId);
    //List<customer>findAllByIsValid(boolean valid);
}
