package school.faang.averagesalary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    public static Map<String, Double> getAverageSalaryOfDepartment(List<Employee> employees) {
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        return averageSalary;
    }
}
