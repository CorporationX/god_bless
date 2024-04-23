package faang.school.godbless.StreameAPI_2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private double salary;
    private String departmen;

    public Employee() {
    }

    public Employee(String name, double salary, String departmen) {
        this.name = name;
        this.salary = salary;
        this.departmen = departmen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen(String departmen) {
        this.departmen = departmen;
    }
    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmen,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
