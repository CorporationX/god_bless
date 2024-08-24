package streamapi.two;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalary {

    public static Map<String, Double> calculatedAverageSalaryByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

}
