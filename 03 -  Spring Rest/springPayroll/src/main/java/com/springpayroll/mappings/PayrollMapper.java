package com.springpayroll.mappings;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Payroll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface PayrollMapper {
    PayrollMapper INSTANCE = Mappers.getMapper(PayrollMapper.class);

    @Mapping(source = "employee.id", target = "employeeId")
    PayrollDTO toPayrollDTO(Payroll payroll);

    @Mapping(source = "employeeId", target = "employee.id")
    Payroll toPayrollEntity(PayrollDTO payrollDTO);
}
