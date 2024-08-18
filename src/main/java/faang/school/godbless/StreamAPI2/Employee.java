package faang.school.godbless.StreamAPI2;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        if (department == null || department.isEmpty()) {
            throw new IllegalArgumentException("Employee department cannot be null or empty");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Employee salary cannot be negative");
        }

        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
