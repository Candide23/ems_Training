package com.training.ems.backend.service.Impl;

import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;
import com.training.ems.backend.mapper.EmployeeMapper;
import com.training.ems.backend.repository.EmployeeRepository;
import com.training.ems.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;



    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(newEmployee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }
}
