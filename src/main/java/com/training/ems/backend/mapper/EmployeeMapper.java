package com.training.ems.backend.mapper;

import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){

        return new Employee(
                employeeDto.getId(),
                employeeDto.getLastName(),
                employeeDto.getFirstName(),
                employeeDto.getEmail()
        );
    }
}
