package bjs2_33404;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> friendsList = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        List<Employee> employees = List.of(
                new Employee("John", 5000, "it"),
                new Employee("Jack", 10000, "it"),
                new Employee("Jess", 1000, "economy"),
                new Employee("Jeff", 10000, "it"),
                new Employee("Jane", 500, "law")
        );

        System.out.println(StreamOperations.searchMutualFriends(friendsList));
        System.out.println(StreamOperations.computeDepartmentsAvgSalary(employees));
        System.out.println(StreamOperations.palindromesFromRange(100, 200));
        System.out.println(StreamOperations.palindromeStrings("abac"));
        System.out.println(StreamOperations.primeNumbers(1, 1000));
    }
}
