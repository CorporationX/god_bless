package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalary {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Vika", 500d, "IT"),
                new Employee("Kostya", 400, "Finance"),
                new Employee("Timur", 1000d, "IT"),
                new Employee("Dima", 300d, "Finance")
        );

        Map<String, Double> result = findAverageSalary(employeeList);
        result.entrySet().forEach((departament) -> System.out.println(departament.getKey() + " :" + departament.getValue()));
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employeeList) {
        Map<String, Double> result = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartament, Collectors.averagingDouble(Employee::getSalary))
        );
        return result;
    }
}
