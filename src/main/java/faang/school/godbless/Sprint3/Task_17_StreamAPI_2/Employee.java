package faang.school.godbless.Sprint3.Task_17_StreamAPI_2;

public class Employee {
    private String name;
    private double salary;
    private String department;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
