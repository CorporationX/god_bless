package school.faang.streamapithree;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        testFindNonFriendPairs();
        testAverageSalaryByDepartment();
        testFindPalindromicNumbers();
        testFindPalindromicSubstrings();
        testFindPerfectNumbers();
    }

    private static void testFindNonFriendPairs() {
        log.info("=== Test 1: Find Non‑Friend Pairs with Mutual Friends ===");
        Map<String, List<String>> network = Map.of(
                "Alice",   List.of("Bob", "Charlie"),
                "Bob",     List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David",   List.of("Bob", "Charlie")
        );
        List<Pair<String, String>> pairs = TrainingStreamApi.findNonFriendPairs(network);
        log.info("Input network: {}", network);
        log.info("Non‑friend pairs with mutuals: {}", pairs);
        // Expected: [(Alice, David), (Bob, Charlie)]
    }

    private static void testAverageSalaryByDepartment() {
        log.info("=== Test 2: Average Salary by Department ===");
        List<Employee> staff = List.of(
                new Employee("John",    60000, "Engineering"),
                new Employee("Jane",    65000, "Engineering"),
                new Employee("Fred",    50000, "Marketing"),
                new Employee("Ann",     55000, "Marketing"),
                new Employee("Susan",   70000, "HR")
        );
        Map<String, Double> avgByDept = TrainingStreamApi.calculateAverageSalaryByDepartment(staff);
        log.info("Employees: {}", staff);
        log.info("Average salaries: {}", avgByDept);
        // Expected: {Engineering=62500.00, Marketing=52500.00, HR=70000.00}
    }

    private static void testFindPalindromicNumbers() {
        log.info("=== Test 3: Find Palindromic Numbers in Range ===");
        int from = 100;
        int to = 200;
        List<Integer> pals = TrainingStreamApi.findPalindromicNumbersInRange(from, to);
        log.info("Range: {}–{}", from, to);
        log.info("Palindromic numbers: {}", pals);
        // Expected: [101, 111, 121, 131, 141, 151, 161, 171, 181, 191]
    }

    private static void testFindPalindromicSubstrings() {
        log.info("=== Test 4: Find Palindromic Substrings ===");
        String input = "abac";
        Set<String> substrings = TrainingStreamApi.findPalindromicSubstrings(input);
        log.info("Input string: \"{}\"", input);
        log.info("Palindromic substrings: {}", substrings);
        // Expected (order may vary): ["a", "aba", "b", "c"]
    }

    private static void testFindPerfectNumbers() {
        log.info("=== Test 5: Find Perfect Numbers in Range ===");
        int start = 1;
        int end = 1000;
        List<Integer> perfects = TrainingStreamApi.findPerfectNumbersInRange(start, end);
        log.info("Range: {}–{}", start, end);
        log.info("Perfect numbers: {}", perfects);
        // Expected: [6, 28, 496]
    }
}

