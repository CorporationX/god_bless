package lets_practice_streamapi_3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SteamAPIManagerTest {
    @Test
    void findNonFriendPairsWithCommonFriends() {
        Map<String, List<String>> friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        assertEquals(
                List.of(List.of("Bob", "Charlie"), List.of("Alice", "David")),
                SteamAPIManager.findNonFriendPairsWithCommonFriends(friends)
        );
    }

    @Test
    void calculateAverageSalaryByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 3000, "IT"),
                new Employee("Bob", 3500, "HR"),
                new Employee("Charlie", 3200, "IT"),
                new Employee("Dave", 4000, "HR"),
                new Employee("Eve", 4500, "Finance"),
                new Employee("Frank", 5000, "Finance")
        );
        Map<String, Double> averageSalaries = SteamAPIManager.calculateAverageSalaryByDepartment(employees);
        assertEquals(Map.of("Finance", 4750.0, "HR", 3750.0, "IT", 3100.0), averageSalaries);
    }

    @Test
    void findPalindromes() {
        List<Integer> palindromesInteger = SteamAPIManager.findPalindromes(100, 200);
        assertEquals(List.of(101, 111,121, 131, 141, 151, 161, 171, 181, 191), palindromesInteger);
    }

    @Test
    void findPalindromeSubstrings() {
        List<String> palindromesString = SteamAPIManager.findPalindromeSubstrings("abcddcba");
        assertEquals(List.of("a", "abcddcba", "b", "bcddcb", "c", "cddc", "d", "dd"), palindromesString);
    }

    @Test
    void findPerfectNumbers() {
        List<Integer> perfectNumbers = SteamAPIManager.findPerfectNumbers(1, 1000);
        assertEquals(List.of(6, 28, 496), perfectNumbers);
    }
}