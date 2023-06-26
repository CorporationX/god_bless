package Sprint_3_Task17;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private int salary ;
    private String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
