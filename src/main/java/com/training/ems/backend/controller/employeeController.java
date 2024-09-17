package com.training.ems.backend.controller;


import com.training.ems.backend.dto.EmployeeDto;
import com.training.ems.backend.entity.Employee;
import com.training.ems.backend.service.EmployeeService;
import com.training.ems.backend.service.Impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeesById(@PathVariable("id") Long id){

        return new ResponseEntity<>(employeeService.getEmployeesById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){

        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

}
