package com.springpayroll.entities;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Character gender;
    private Date startDate;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Payroll payroll;
}
