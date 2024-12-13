package school.faang.sprint2.task_46792;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTraining {

    public Map<String, Double> avgSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    public List<Integer> findPalindrome(int minBound, int maxBound) {
        return IntStream.rangeClosed(minBound, maxBound)
                .filter((num) -> {
                    String string = String.valueOf(num);
                    StringBuilder sb = new StringBuilder(string);
                    return Objects.equals(string, sb.reverse().toString());
                })
                .boxed().toList();
    }
}
