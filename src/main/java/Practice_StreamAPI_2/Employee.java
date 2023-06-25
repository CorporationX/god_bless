package Practice_StreamAPI_2;

public class Employee {
    private String name;
    private double salary;
    private Department department;

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee(String name, double salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}

enum Department {
    SALES, HR, MARKETING, CUSTOMER_SUPPORT
}