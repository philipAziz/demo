package com.example.demo.services;


import com.example.demo.model.employee;
import com.example.demo.model.employeeVacationDTO;
import com.example.demo.model.vacation;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.VacationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service("vacationService")
public class vacationServiceImpl implements vacationService{
    @Autowired
    VacationRepo repo;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public employeeVacationDTO addVacation(vacation vacation) {
         employeeVacationDTO dto= new employeeVacationDTO();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(vacation.getStartDate());
        cal2.setTime(vacation.getEndDate());

        int numberOfDays = 0;
        while (cal1.before(cal2)) {
            if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))&&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
                cal1.add(Calendar.DATE,1);
            }else {
                cal1.add(Calendar.DATE,1);
            }
        }
        Optional<employee> employee=employeeService.findById(1);
        if(vacation.getType()==1) {
             int currentAnnual=employee.get().getAnnualBalance()-numberOfDays;
            employee.get().setAnnualBalance(currentAnnual);
        }
        else{
            int currentSick= employee.get().getSickBalance()-numberOfDays;
            employee.get().setSickBalance(currentSick);
        }

        vacation.setAmount(numberOfDays);
        employeeRepo.save(employee.get());
         repo.save(vacation);
         dto.setVacation(vacation);
         dto.setEmployee(employee.get());
         return dto;
    }
}

