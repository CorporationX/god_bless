package school.faang;

import lombok.Getter;

@Getter
public class Employee {
    private final String name;
    private final int salary;
    private final String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
