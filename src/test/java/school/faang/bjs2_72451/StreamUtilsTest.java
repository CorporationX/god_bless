package school.faang.bjs2_72451;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamUtilsTest {

    @Test
    void testFindPeopleWithCommonFriends() {
        Map<String, List<String>> friendsMap = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        List<Map.Entry<String, String>> result = StreamUtils.findPeopleWithCommonFriends(friendsMap);

        Set<Set<String>> actualPairs = new HashSet<>();
        result.forEach(entry -> actualPairs.add(Set.of(entry.getKey(), entry.getValue())));

        Set<Set<String>> expectedPairs = Set.of(
                Set.of("Alice", "David"),
                Set.of("Bob", "Charlie")
        );

        assertEquals(expectedPairs, actualPairs);
    }

    @Test
    void testAverageSalaryByDepartment() {
        List<Employee> employees = List.of(
                new Employee("John", 1000.0, "IT"),
                new Employee("Jane", 1500.0, "IT"),
                new Employee("Jack", 1200.0, "HR"),
                new Employee("Jill", 800.0, "HR")
        );

        Map<String, Double> result = StreamUtils.averageSalaryByDepartment(employees);

        assertEquals(1250.0, result.get("IT"));
        assertEquals(1000.0, result.get("HR"));
    }

    @Test
    void testFindPalindromes() {
        List<Integer> result = StreamUtils.findPalindromes(100, 200);
        List<Integer> expected = List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        assertEquals(expected, result);
    }

    @Test
    void testFindAllPalindromicSubstrings() {
        String input = "abac";
        List<String> result = StreamUtils.findAllPalindromicSubstrings(input);
        Set<String> expected = Set.of("a", "b", "c", "aba");
        assertEquals(expected, new HashSet<>(result));
    }

    @Test
    void testFindPerfectNumbers() {
        List<Integer> result = StreamUtils.findPerfectNumbers(1, 1000);
        List<Integer> expected = List.of(6, 28, 496);
        assertEquals(expected, result);
    }
}
