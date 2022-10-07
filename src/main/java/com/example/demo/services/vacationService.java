package com.example.demo.services;


import com.example.demo.model.employeeVacationDTO;
import com.example.demo.model.vacation;

public interface vacationService   {

    employeeVacationDTO addVacation(vacation vacation);
}
