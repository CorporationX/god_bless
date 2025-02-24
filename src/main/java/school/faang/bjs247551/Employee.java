package school.faang.bjs247551;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private String name;
    private Double salary;
    private String department;

    public Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(el -> el.department,
                        Collectors.averagingDouble(el -> el.salary)));
    }

}
