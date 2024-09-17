package com.training.ems.backend.service;

import com.training.ems.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeesById(Long id);
    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee( Long id, EmployeeDto employeeDto);




}
