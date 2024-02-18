package faang.school.godbless.trainingstreamapi2_2639;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
