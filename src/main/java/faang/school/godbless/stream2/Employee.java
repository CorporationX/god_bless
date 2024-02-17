package faang.school.godbless.stream2;

public class Employee {
    private final String name;
    private final int salary;
    private final String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;

    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
