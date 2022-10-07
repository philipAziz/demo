package com.example.demo.controllers;

import com.example.demo.model.employeeVacationDTO;
import com.example.demo.model.vacation;
import com.example.demo.services.vacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class vacationController {
    @Autowired
    vacationService vacationService;

    @RequestMapping(value = "/vacation", method = RequestMethod.POST)
    public employeeVacationDTO addVacation(@RequestBody vacation vacation) {
        return vacationService.addVacation(vacation);



        

    }


}
