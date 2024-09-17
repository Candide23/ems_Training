package com.training.ems.backend.service.Impl;

import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;
import com.training.ems.backend.exception.ResourceNotFoundException;
import com.training.ems.backend.mapper.EmployeeMapper;
import com.training.ems.backend.repository.EmployeeRepository;
import com.training.ems.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeesById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employeeId not found" + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employeeId not found" + id));

        employee.setLastName(employeeDto.getLastName());
        employee.setFirstName(employeeDto.getFirstName());
       employee.setEmail(employeeDto.getEmail());

       Employee upEmployee = employeeRepository.save(employee);



        return EmployeeMapper.mapToEmployeeDto(upEmployee);
    }
}
