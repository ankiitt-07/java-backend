package com.springpayroll.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payroll")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double salary;

    @OneToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employee employee;
}
