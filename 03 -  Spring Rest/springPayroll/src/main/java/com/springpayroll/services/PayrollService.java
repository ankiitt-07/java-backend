package com.springpayroll.services;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Employee;
import com.springpayroll.mappings.PayrollMapper;
import com.springpayroll.entities.Payroll;
import com.springpayroll.repositories.IEmployeeRepository;
import com.springpayroll.repositories.IPayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayrollService {
    private final IPayrollRepository payrollRepository;
    private final IEmployeeRepository employeeRepository;
    private final PayrollMapper payrollMapper;

    public PayrollService(IPayrollRepository payrollRepository, IEmployeeRepository employeeRepository, PayrollMapper payrollMapper) {
        this.payrollRepository = payrollRepository;
        this.payrollMapper = payrollMapper;
        this.employeeRepository = employeeRepository;
    }

    public PayrollDTO getPayrollById(int id) {
        Optional<Payroll> payrollOpt = payrollRepository.findById(id);
        if (payrollOpt.isPresent()) {
            return payrollMapper.toPayrollDTO(payrollOpt.get());
        } else {
            throw new RuntimeException("Payroll not found");
        }
    }

    public List<PayrollDTO> getAllPayrolls() {
        List<Payroll> payrolls = payrollRepository.findAll();
        return payrolls.stream().map(payrollMapper::toPayrollDTO).collect(Collectors.toList());
    }

    public void createPayroll(PayrollDTO payrollDTO) {
        Employee employee = employeeRepository.findById(payrollDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Payroll payroll = payrollMapper.toPayrollEntity(payrollDTO);
        payroll.setEmployee(employee);
        payrollRepository.save(payroll);
    }

    public void updatePayroll(Integer id, PayrollDTO payrollDTO) {
        Payroll payroll = payrollMapper.toPayrollEntity(payrollDTO);
        payroll.setId(id);
        payrollRepository.save(payroll);
    }

    public void deletePayroll(Integer id) {
        payrollRepository.deleteById(id);
    }
}
