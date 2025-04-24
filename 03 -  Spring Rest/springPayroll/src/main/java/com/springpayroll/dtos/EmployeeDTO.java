package com.springpayroll.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import java.io.Serializable;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Name must be 2-50 characters and contain only letters and spaces")

    private String name;

    @NotEmpty(message = "Gender must not be empty")
    @Pattern(regexp = "M | F", message = "Gender needs to be M or F")

    private Character gender;

    @NotNull(message = "startDate must not be null")
    @JsonFormat(pattern = "dd MM yyyy")
    @PastOrPresent(message = "startDate should be past or present")

    private Date startDate;

    private PayrollDTO payroll;
}
