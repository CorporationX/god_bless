package school.faang.sprint_2.task_47420;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamOperationsTest {

    @Test
    public void findCommonFriendsTest() {
        Map<String, List<String>> usersFriends = new HashMap<>();
        usersFriends.put("Alice", Arrays.asList("Bob", "Charlie,"));
        usersFriends.put("Bob", Arrays.asList("Alice", "David"));
        usersFriends.put("Charlie", Arrays.asList("Alice", "David"));
        usersFriends.put("David", Arrays.asList("Bob", "Charlie"));

        Set<List<String>> expected = Set.of(List.of("Bob", "Charlie"), List.of("Alice", "David"));
        Set<List<String>> result = StreamOperations.findCommonFriends(usersFriends);

        assertTrue(result.containsAll(expected));
    }

    @Test
    public void calculateAverageSalaryTest() {
        Employee alex = new Employee("Alex", 100, "IT");
        Employee bob = new Employee("Bob", 50, "IT");
        Employee tom = new Employee("Tom", 100, "Design");
        Employee sara = new Employee("Sara", 300, "Design");
        List<Employee> employees = List.of(alex, bob, tom, sara);

        Map<String, Double> expected = Map.of("Design", 200.0, "IT", 75.0);
        Map<String, Double> result = StreamOperations.calculateAverageSalary(employees);

        assertEquals(expected, result);
    }

    @Test
    public void findPalindromeNumbersTest() {
        List<String> expected = List.of("101", "111", "121", "131", "141", "151", "161", "171", "181", "191");
        List<String> result = StreamOperations.findPalindromeNumbers(100, 200);

        assertEquals(expected, result);
    }

    @Test
    public void findPalindromeSubstringsTest() {
        List<String> expected = List.of("afa", "a", "aba", "b", "c", "f", "aca");
        List<String> result = StreamOperations.findPalindromeSubstrings("abacafa");

        assertEquals(expected, result);
    }

    @Test
    public void findPerfectNumbers() {
        List<Integer> expected = List.of(6, 28, 496);
        List<Integer> result = StreamOperations.findPerfectNumbers(1000);
    
        assertEquals(expected, result);
    }

}
