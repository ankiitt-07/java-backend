package com.springpayroll.mappings;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PayrollMapper.class)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "payroll", target = "payroll")
    EmployeeDTO toEmployeeDTO(Employee employee);

    @Mapping(source = "payroll", target = "payroll")
    Employee toEmployeeEntity(EmployeeDTO employeeDTO);
}