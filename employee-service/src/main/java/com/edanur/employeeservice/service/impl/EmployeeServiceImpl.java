package com.edanur.employeeservice.service.impl;

import com.edanur.employeeservice.dto.APIResponseDto;
import com.edanur.employeeservice.dto.DepartmentDto;
import com.edanur.employeeservice.dto.EmployeeDto;
import com.edanur.employeeservice.entity.Employee;
import com.edanur.employeeservice.repository.EmployeeRepository;
import com.edanur.employeeservice.service.APIClient;
import com.edanur.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;

   // private WebClient webClient;

    private APIClient apiClient;

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
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

      /*  ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"
                                                        + employee.getDepartmentCode(),
                                                         DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();  */

      /* DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/"+ employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();  */

       DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
 
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
