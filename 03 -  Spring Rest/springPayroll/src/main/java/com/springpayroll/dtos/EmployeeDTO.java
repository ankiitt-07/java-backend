package com.springpayroll.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Name must be 2-50 characters and contain only letters and spaces")

    private String name;
    private PayrollDTO payroll;
}
