package com.stream.training2;

import lombok.Getter;

@Getter
public class Employee {
    private String name;
    private double salary;
    private String departmentName;

    public Employee(String name, double salary, String departmentName) {
        this.name = name;
        this.salary = salary;
        this.departmentName = departmentName;
    }
}
