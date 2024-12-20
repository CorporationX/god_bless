package school.faang.bjs_46821;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamApiOperation3Test {

    @Test
    void noFriendsPair() {
        Map<String, List<String>> users = Map.of("Alice", Arrays.asList("Bob", "Charlie"),
                "Bob", Arrays.asList("Alice", "David"), "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Bob", "Charlie"));

        List<List<String>> expected = List.of(List.of("Alice", "David"), List.of("Bob", "Charlie"));
        List<List<String>> actual = StreamApiOperation3.noFriendsPair(users);
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void avgSalary() {
        List<Employee> employees = Arrays.asList(new Employee("Alice", 3000, "IT"),
                new Employee("Bob", 3450, "Department 1"),
                new Employee("Charlie", 4500, "Department 1"),
                new Employee("David", 4500, "Department 2"),
                new Employee("Eve", 4500, "Department 2"));

        Map<String, Double> actual = StreamApiOperation3.avgSalary(employees);
        Map<String, Double> expected = Map.of("Department 2", 4500.0, "Department 1", 3975.0,
                "IT", 3000.0);
        assertEquals(expected, actual);
    }

    @Test
    void isPalindromeNumber() {
        int start = 100;
        int end = 200;
        List<Integer> expected = Arrays.asList(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        List<Integer> actual = StreamApiOperation3.palindromeNumbers(start, end);
        assertEquals(expected, actual);
    }

    @Test
    void palindromeSubStrings() {
        String input = "abac";
        Set<String> actual = StreamApiOperation3.palindromeSubStrings(input);
        Set<String> expected = Set.of("a", "aba", "b", "c");
        assertEquals(expected, actual);
    }

    @Test
    void perfectNumbers() {
        int start = 1;
        int end = 1000;
        Set<Integer> expected = Set.of(6, 28, 496);
        Set<Integer> actual = StreamApiOperation3.perfectNumbers(start, end);
        assertEquals(expected, actual);
    }
}