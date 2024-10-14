package school.faang.averagesalary;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("James", 1300, "Development department"),
                new Employee("Gustavo", 1750, "Development department"),
                new Employee("Vikky", 2500, "Development department"),
                new Employee("Gordon", 1350, "Marketing and Sales Department"),
                new Employee("Richard", 1400, "Marketing and Sales Department"),
                new Employee("Johnson", 2800, "Marketing and Sales Department"),
                new Employee("Jeff", 1250, "Technical support department"),
                new Employee("Betty", 1460, "Technical support department"),
                new Employee("Rufy", 1950, "Technical support department")
        );

        Map<String, Double> averageSalaryByDepartment = EmployeeService.getAverageSalaryOfDepartment(employees);
        averageSalaryByDepartment.forEach((key, value) ->
                System.out.println("Department: " + key + " | Average salary: " + value));
    }
}
