package com.training.ems.backend.service;

import com.training.ems.backend.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeesById(Long id);


}
