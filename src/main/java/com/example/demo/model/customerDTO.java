package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class customerDTO {
    private customer customer;
    private country country;
    private Boolean valid;
}
