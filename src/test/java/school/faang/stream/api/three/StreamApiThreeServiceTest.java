package school.faang.stream.api.three;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamApiThreeServiceTest {
    @Test
    public void findMutualFriendsTest() {
        List<Map<String, String>> expected = Arrays.asList(
                Map.of("Alice", "David"),
                Map.of("Bob", "Charlie")
        );
        List<Map<String, String>> result = StreamApiThreeService.findMutualFriends(getPeopleFriends());
        assertEquals(expected, result);
    }

    @Test
    public void findAverageSalaryTest() {
        Map<String, Double> expected = Map.of(
                "IT", 150000.00,
                "Salary", 100000.00
        );
        Map<String, Double> result = StreamApiThreeService.findAverageSalary(getEmployees());
        assertEquals(expected, result);
    }

    @Test
    public void findNumbersPalindromeTest() {
        List<Integer> expected = Arrays.asList(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        List<Integer> result = StreamApiThreeService.findNumbersPalindrome(100, 200);
        assertEquals(expected, result);
    }

    @Test
    public void findStringPalindromeTest() {
        List<String> expected = Arrays.asList("a", "aba", "b", "c");
        List<String> result = StreamApiThreeService.findStringPalindrome("abac");
        assertEquals(expected, result);
    }

    @Test
    public void findPerfectNumbersTest() {
        List<Integer> expected = Arrays.asList(6, 28, 496);
        List<Integer> result = StreamApiThreeService.findPerfectNumbers(1, 1000);
        assertEquals(expected, result);
    }

    private Map<String, List<String>> getPeopleFriends() {
        return Map.of(
                "Alice", Arrays.asList("Bob", "Charlie"),
                "Bob", Arrays.asList("Alice", "David"),
                "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Bob", "Charlie")
        );
    }

    private List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Employee1", 100000, "IT"),
                new Employee("Employee2", 150000, "IT"),
                new Employee("Employee3", 200000, "IT"),
                new Employee("Employee4", 80000, "Salary"),
                new Employee("Employee5", 100000, "Salary"),
                new Employee("Employee6", 120000, "Salary")
        );
    }
}
