package com.edanur.employeeservice.service;

import com.edanur.employeeservice.dto.APIResponseDto;
import com.edanur.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

   APIResponseDto getEmployeeById(Long employeeId);
}
