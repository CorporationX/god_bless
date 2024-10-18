package school.faang.streamapi3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, List<String>> friendMap = Map.of(
                "Alice", Arrays.asList("Bob", "Charlie"),
                "Bob", Arrays.asList("Alice", "David"),
                "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Charlie", "Bob")
        );

        System.out.println(StreamApiTester.getJointFriends(friendMap));

        List<Employee> employees = List.of(
                new Employee("Ivan", 300, "Department1"),
                new Employee("Kate", 500, "Department2"),
                new Employee("Dana", 600, "Department3"),
                new Employee("Mike", 400, "Department3"),
                new Employee("Alex", 250, "Department2"),
                new Employee("Dave", 100, "Department2"),
                new Employee("Pete", 150, "Department2")
        );

        System.out.println(StreamApiTester.getAverageSalary(employees));

        System.out.println(StreamApiTester.getPalindromes(100, 200));

        System.out.println(StreamApiTester.getPerfectNumber(1, 1000));

        System.out.println(StreamApiTester.getSubstringPalindromes("abac"));

    }
}
