package com.springpayroll.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Integer id;
    private String name;
    private PayrollDTO payroll;
}
