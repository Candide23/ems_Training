package com.training.ems.backend.controller;


import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;
import com.training.ems.backend.service.EmployeeService;
import com.training.ems.backend.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class employeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity <EmployeeDto> createEmployees(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);



    }

}
