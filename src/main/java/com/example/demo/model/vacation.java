package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="vacation")
public class vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "type_id")
    private int type;
    @Column(name = "eid")
    private int employeeId=1;
    @Column(name = "amount")
    private int amount;
    @Column(name = "vacation_from")
    private Date startDate;
    @Column(name = "vacation_to")
    private Date endDate;

}
