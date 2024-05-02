package com.jimmysalazar.lombokexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
//@AllArgsConstructor
@Builder
public class Employee {
    private Integer id;
    private String lastName;
    private String name;
    private float salary;

    @Singular // Allows to add addresses one by one
    private List<String> addresses;

    @Builder.Default // Valor por defecto que puede no incluirse en el Builder
    private EmployeeType employeeType = EmployeeType.VENDOR;
}
