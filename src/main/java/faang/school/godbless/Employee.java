package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Employee {
    private String name;
    private int salary;
    private String department;
    public static Map<String, Double> averageSalary(){
        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000, "Sales"),
                new Employee("Michael", 7000, "Marketing"),
                new Employee("Mary", 6000, "Sales"),
                new Employee("David", 8000, "IT"),
                new Employee("Alice", 7500, "Marketing"),
                new Employee("Bob", 8500, "IT"));
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
        return averageSalaryByDepartment;

    }
}
