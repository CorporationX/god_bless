package school.faang.bjs2_70914;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie"),
                "Eve", List.of("Frank"),
                "Frank", List.of("Eve")
        );
        List<Employee> employees = List.of(
                new Employee("Alice", 1000, "HR"),
                new Employee("Bob", 2000, "IT"),
                new Employee("Charlie", 3000, "IT"),
                new Employee("Diana", 1500, "HR")
        );

        log.info("Pairs of non-friends: {}", CollectionOperations.findAllNonFriendsWithCommonFriends(friends));
        log.info("Average department salary: {}",
                CollectionOperations.groupByDepartmentAndFindAverageSalary(employees));
        log.info("Palindromes from 100 to 200: {}", CollectionOperations.findPalindromes(100, 200));
        log.info("Palindrome substrings from 'abac': {}", CollectionOperations.findAllPalindromeSubstrings("abac"));
        log.info("Perfect numbers from 1 to 1000: {}", CollectionOperations.findPerfectNumbers(1, 1000));
    }
}