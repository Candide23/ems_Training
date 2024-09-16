package com.training.ems.backend.service.Impl;

import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;
import com.training.ems.backend.mapper.EmployeeMapper;
import com.training.ems.backend.repository.EmployeeRepository;
import com.training.ems.backend.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements employeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(newEmployee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }
}
