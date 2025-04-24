package com.springpayroll.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayrollDTO {
    private Integer id;
    private double salary;
    private Integer employeeId;
}
