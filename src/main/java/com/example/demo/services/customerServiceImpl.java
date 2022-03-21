package com.example.demo.services;

import com.example.demo.model.customer;
import com.example.demo.model.customerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("customerService")
public class customerServiceImpl implements customerService{
    @Autowired
    com.example.demo.repo.customerRepo customerRepo;
    @Autowired
    countryService countryService;
    @Override
    public Iterable<customer> findAll() {
        return customerRepo.findAll();
    }
    @Override
    public List<customerDTO> getCustomers(Optional<Long> countryId, Optional<Boolean> valid) {
        List<customerDTO> dtoList = new ArrayList<>();
        if(countryId.isEmpty())
        {
            for (customer cust : this.findAll()) {
                customerDTO dto = this.entityToDto(cust);
                dtoList.add(dto);
            }
        }
      else if(countryId.isPresent()&& countryId.get() > 0)
        {
            for (customer cust : this.findByCountry(countryId.get())) {
                customerDTO dto = this.entityToDto(cust);
                dtoList.add(dto);
            }
        }
      if (valid.isPresent())
      {
          List<customerDTO> list=dtoList.stream()
                  .filter(c -> c.getValid() ==valid.get())
                  .collect(Collectors.toList());
              return list;
      }
        return dtoList;
    }



    @Override
    public boolean validate(String countryPattern,String phone) {
        Pattern r = Pattern.compile(countryPattern);
        Matcher m = r.matcher(phone);
        if (m.matches()) {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<customer> findByCountry(Long countryId) {

        return customerRepo.findAllByContId(countryId);
    }

    @Override
    public customerDTO entityToDto(customer cust) {
        customerDTO dto =new customerDTO();
        dto.setCustomer(cust);
        dto.setCountry(countryService.findById(cust.getContId()).get());
        dto.setValid(validate(countryService.findById(cust.getContId()).get().getCode(),cust.getPhone()));
        return dto;
    }

}
