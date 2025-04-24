package com.springpayroll.services;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.mappings.EmployeeMapper;
import com.springpayroll.entities.Employee;
import com.springpayroll.repositories.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(IEmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            return employeeMapper.toEmployeeDTO(employeeOpt.get());
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toEmployeeDTO).collect(Collectors.toList());
    }

    public void createEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeMapper.toEmployeeEntity(employeeDTO));
    }

    public void updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployeeEntity(employeeDTO);
        employee.setId(id);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
