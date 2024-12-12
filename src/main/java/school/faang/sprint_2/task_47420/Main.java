package school.faang.sprint_2.task_47420;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee alex = new Employee("Alex", 100, "IT");
        Employee bob = new Employee("Bob", 50, "IT");
        Employee tom = new Employee("Tom", 100, "Design");
        Employee sara = new Employee("Sara", 300, "Design");

        List<Employee> employees = List.of(alex, bob, tom, sara);

        System.out.println(StreamOperations.calculateAverageSalary(employees));
        System.out.println(StreamOperations.findPalindromeNumbers(100, 200));
        System.out.println(StreamOperations.findPerfectNumbers(1000));
        System.out.println(StreamOperations.findPalindromeSubstrings("abacafa"));

        Map<String, List<String>> usersFriends = new HashMap<>();
        usersFriends.put("Alice", Arrays.asList("Bob", "Charlie,"));
        usersFriends.put("Bob", Arrays.asList("Alice", "David"));
        usersFriends.put("Charlie", Arrays.asList("Alice", "David"));
        usersFriends.put("David", Arrays.asList("Bob", "Charlie"));

        System.out.println(StreamOperations.findCommonFriends(usersFriends));
    }
}
