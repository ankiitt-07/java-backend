package com.springpayroll.mappings;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Department;
import com.springpayroll.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public interface EmployeeMapper {
    @Mapping(source = "payroll.id", target = "payrollId")
    @Mapping(source = "departments", target = "deptIds")

    EmployeeDTO toEmployeeDTO(Employee employee);

    @Mapping(source = "payrollId", target = "payroll.id")
    @Mapping(source = "deptIds", target = "departments")

    Employee toEmployeeEntity(EmployeeDTO employeeDTO);

    default List<Integer> mapDepartmentsToIds(List<Department> departments) {
        if (departments == null) {
            return null;
        }
        return departments.stream()
                .map(Department::getId)
                .collect(Collectors.toList());
    }

    default List<Department> mapIdsToDepartments(List<Integer> ids) {
        return ids == null ? null : new ArrayList<>();
    }
}