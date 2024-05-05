package com.edanur.departmentservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;


}
