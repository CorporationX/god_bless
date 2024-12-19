package school.faang.moduleone.sprinttwo.task_43540;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, List<String>> sourceMap = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        System.out.println(TaskUtils.findPairsWithCommonFriends(sourceMap));

        List<Employee> source = List.of(
                new Employee("Alice", 2000, "Dep1"),
                new Employee("Bob", 1500, "Dep2"),
                new Employee("Charlie", 2500, "Dep1"),
                new Employee("David", 1000, "Dep2"),
                new Employee("John", 3000, "Dep1")
        );
        System.out.println(TaskUtils.getAverageSalaryByDepartment(source));

        System.out.println(TaskUtils.findPalindromeNumbersInRange(100, 200));

        System.out.println(TaskUtils.findSubstringsPalindromes("abac"));

        System.out.println(TaskUtils.findAllPerfectNumbersInRange(1, 1000));
    }
}
