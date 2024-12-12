package school.faang.sprint_2.task_46860;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> friendships = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        List<List<String>> result = StreamOperations.getCrossFriends(friendships);
        result.forEach(System.out::println);

        List<Employee> employees = List.of(new Employee("Bob1", 1000, "IT"),
                new Employee("Bob2", 3000, "IT"),
                new Employee("Bob3", 1000, "HR"),
                new Employee("Bob4", 5000, "HR"));
        Map<String, Double> averageSalaryInDepartments = StreamOperations.getAverageSalaryInDepartments(employees);
        System.out.println(averageSalaryInDepartments);

        System.out.println(StreamOperations.findPalindromes(100, 200));

        System.out.println(StreamOperations.findSubStringPalindromes("abac"));

        System.out.println(StreamOperations.findPerfectNumbers(1, 1000));
    }
}
