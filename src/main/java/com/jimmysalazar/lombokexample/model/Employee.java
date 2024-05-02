package com.jimmysalazar.lombokexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
//@AllArgsConstructor
@Builder
public class Employee {
    private Integer id;
    private String lastName;
    private String name;
    private float salary;

    private List<String> addresses;

    private EmployeeType employeeType;
}
