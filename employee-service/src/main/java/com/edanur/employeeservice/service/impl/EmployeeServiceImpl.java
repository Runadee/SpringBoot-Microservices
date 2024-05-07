package com.edanur.employeeservice.service.impl;

import com.edanur.employeeservice.dto.EmployeeDto;
import com.edanur.employeeservice.entity.Employee;
import com.edanur.employeeservice.repository.EmployeeRepository;
import com.edanur.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

       Employee savedEmployee =  employeeRepository.save(employee);

       EmployeeDto savedEmployeeDto = new EmployeeDto(
               savedEmployee.getId(),
               savedEmployee.getFirstName(),
               savedEmployee.getLastName(),
               savedEmployee.getEmail(),
               employee.getDepartmentCode()
       );

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        return employeeDto;
    }
}
