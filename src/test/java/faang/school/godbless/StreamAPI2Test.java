package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamAPI2Test {
    StreamAPI2 taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new StreamAPI2();
    }

    @Test
    void testFindUniquePairs() {
        var data = Arrays.asList(1, 2, 3, 4, 5);
        int targetSum = 6;
        var result = taskManager.findUniquePairs(data, targetSum);
        var expectedData = new HashSet<>(Arrays.asList(new Pair<Integer>(5, 1), new Pair<Integer>(4, 2)));

        assertEquals(result, expectedData);
    }

    @Test
    void testSortCountries() {
        Map<String, String> data = new HashMap<>();
        data.put("Russia", "Moscow");
        data.put("Portugal", "Lisbon");
        data.put("Serbia", "Belgrade");

        var result = taskManager.sortCountries(data);
        assertEquals(result, Arrays.asList("Lisbon", "Moscow", "Belgrade"));
    }

    @Test
    void testSortStrings() {
        List<String> words = Arrays.asList("1234", "123", "12", "0", "4444");

        var result = taskManager.sortStrings(words, '1');
        assertEquals(result, Arrays.asList("12", "123", "1234"));
    }

    @Test
    void testCalculateAvgSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 100.0, "HR"),
                new Employee("Alice", 200.0, "Finance"),
                new Employee("Bob", 300.0, "HR"),
                new Employee("Jane", 150.0, "Finance"),
                new Employee("Mike", 9999.0, "IT")
        );
        var result = taskManager.calculateAvgSalary(employees);
        assertEquals(result.size(), 3);
    }

    @Test
    void testStringFilter() {
        List<String> strings = Arrays.asList("1234", "23e4", "4e56", "we", "we12", "333");
        var result = taskManager.stringFilter(strings, "we");
        assertEquals(result, List.of("we"));
    }

    @Test
    void testIntToString() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 0);
        var result = taskManager.intToString(numbers);
        assertEquals(result, Arrays.asList("1", "10", "11", "0"));
    }

    @Test
    void testPalindromes() {
        var result = taskManager.getPalindromes(10, 50);
        var expected = Arrays.asList(11, 22, 33, 44);
        assertEquals(expected, result);
    }

    @Test
    void testFindPossibleFriends() {
        Map<String, List<String>> fr = Map.of(
                "1", List.of("3"),
                "2", List.of("3"),
                "3", Arrays.asList("1", "2")
        );
        var result = taskManager.findPossibleFriends(fr);
        assertEquals(1, result.size());
    }

}