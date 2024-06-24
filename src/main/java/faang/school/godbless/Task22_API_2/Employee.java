package faang.school.godbless.Task22_API_2;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Employee {

    private String name;
    private int salary;
    private String department;

    public Employee(String name, int salary, String department) {
        if (name.isBlank() || salary <= 0 || department.isBlank()) throw new IllegalArgumentException();
        else {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }
    }

    public static Map<String, Double> findAvgSalary(List<Employee> workers) {
        Map<String, Double> result = new HashMap<>();
        Set<String> departments = workers.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
        for (String x : departments) {
            OptionalDouble departmentAvg = workers.stream()
                    .filter(worker -> worker.getDepartment().equals(x))
                    .map(Employee::getSalary)
                    .mapToDouble(Integer::intValue)
                    .average();
            departmentAvg.ifPresent((double y) -> result.put(x, departmentAvg.getAsDouble()));
        }
        return result;
    }
}
