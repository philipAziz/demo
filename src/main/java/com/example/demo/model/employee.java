package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="employee")
public class employee {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "annual_balance")
    private int annualBalance;
    @Column(name = "sick_balance")
    private int sickBalance;

}