package com.springpayroll.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PayrollDTO implements Serializable {
    private Integer id;
    private double salary;
    private Integer employeeId;
}
