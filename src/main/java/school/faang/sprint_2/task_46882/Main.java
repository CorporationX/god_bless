package school.faang.sprint_2.task_46882;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        List<Employee> employees = List.of(new Employee("Ivan", 300000, "marketing"),
                new Employee("Max", 250000, "salespeople"),
                new Employee("Alex", 350000, "admin"),
                new Employee("Bob", 183000, "IT specialist"),
                new Employee("Ben", 231500, "marketing"),
                new Employee("Mask", 437001, "IT specialist"),
                new Employee("Luke", 501826, "marketing"),
                new Employee("Padme", 234000, "marketing")
        );

        System.out.printf("People with mutual friends: %s\n", Service.strangersWithMutualFriends(friends));

        System.out.printf("Average salary for department: %s\n", Service.averageSalaryForEachDepartment(employees));

        System.out.printf("Palindromic numbers in a given range: %s\n", Service.palindromicNumbers(100, 200));

        System.out.printf("Palindrome substrings: %s\n", Service.palindromeSubstrings("abac"));

        System.out.printf("Perfect numbers in a given range: %s\n", Service.perfectNumbers(1, 1000));
    }
}
