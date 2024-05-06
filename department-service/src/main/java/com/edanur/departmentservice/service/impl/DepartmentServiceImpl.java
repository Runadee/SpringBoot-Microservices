package com.edanur.departmentservice.service.impl;

import com.edanur.departmentservice.dto.DepartmentDto;
import com.edanur.departmentservice.entity.Department;
import com.edanur.departmentservice.repository.DepartmentRepository;
import com.edanur.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
         Department department = new Department(
                 departmentDto.getId(),
                 departmentDto.getDepartmentName(),
                 departmentDto.getDepartmentDescription(),
                 departmentDto.getDepartmentCode()
         );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }
}
