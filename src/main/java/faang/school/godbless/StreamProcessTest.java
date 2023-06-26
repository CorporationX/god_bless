package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StreamProcessTest {

    @Test
    void testFindPairsWithSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int targetSum = 7;
        List<List<Integer>> expectedPairs = Arrays.asList(
                Arrays.asList(3, 4),
                Arrays.asList(2, 5),
                Arrays.asList(1, 6)
        );

        List<List<Integer>> actualPairs = StreamProcess.findPairsWithSum(numbers, targetSum);

        // Сортируем каждую пару в ожидаемых и фактических парах
        expectedPairs.forEach(Collections::sort);
        actualPairs.forEach(Collections::sort);

        Set<List<Integer>> uniqueExpectedPairs = new HashSet<>(expectedPairs);

        Set<List<Integer>> uniqueActualPairs = new HashSet<>(actualPairs);

        assertEquals(uniqueExpectedPairs, uniqueActualPairs);
    }

    @Test
    public void testSortCapitalsByCountry() {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Germany", "Berlin");
        countryCapitalMap.put("Italy", "Rome");
        countryCapitalMap.put("Spain", "Madrid");
        List<String> expectedSortedCapitals = Arrays.asList("Paris", "Berlin", "Rome", "Madrid");

        List<String> actualSortedCapitals = StreamProcess.sortCapitalByCountry(countryCapitalMap);

        assertEquals(expectedSortedCapitals, actualSortedCapitals);
    }

    @Test
    public void testFilterAndSortStringsByChar() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        char prefix = 'b';
        List<String> expectedFilteredAndSortedStrings = Arrays.asList("banana");

        List<String> actualFilteredAndSortedStrings = StreamProcess.filterAndSortStringsByChar(strings, prefix);

        assertEquals(expectedFilteredAndSortedStrings, actualFilteredAndSortedStrings);
    }

    @Test
    public void testFindNonFriendPairs() {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendships.put("Bob", Arrays.asList("Alice", "Eve"));
        friendships.put("Charlie", Arrays.asList("Alice", "Dave"));
        friendships.put("Dave", Arrays.asList("Charlie", "Eve"));
        List<List<String>> expectedNonFriendPairs = Arrays.asList(

                Arrays.asList("Bob", "Charlie"),
                Arrays.asList("Bob", "Dave"),
                Arrays.asList("Alice", "Dave")
        );

        List<List<String>> actualNonFriendPairs = StreamProcess.findNonFriendPairs(friendships);

        assertEquals(expectedNonFriendPairs, actualNonFriendPairs);
    }

    @Test
    public void testCalculateAverageSalaryByDepartment() {
        Employee emp1 = new Employee("Alice", 5000, "IT");
        Employee emp2 = new Employee("Bob", 6000, "HR");
        Employee emp3 = new Employee("Charlie", 5500, "IT");
        Employee emp4 = new Employee("Dave", 7000, "Finance");
        Employee emp5 = new Employee("Eve", 4500, "IT");
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
        Map<String, Double> expectedAverageSalaries = new HashMap<>();
        expectedAverageSalaries.put("IT", 5000.0);
        expectedAverageSalaries.put("HR", 6000.0);
        expectedAverageSalaries.put("Finance", 7000.0);

        Map<String, Double> actualAverageSalaries = StreamProcess.calculateAverageWageByDepartment(employees);

        assertEquals(expectedAverageSalaries, actualAverageSalaries);
    }

    @Test
    public void testFilterAndSortAlphabeticStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        String alphabet = "a-s";
        List<String> expectedFilteredAndSortedStrings = Arrays.asList("dog", "apple", "banana");

        List<String> actualFilteredAndSortedStrings = StreamProcess.filterAndSortAlphabeticStrings(strings, alphabet);

        assertEquals(expectedFilteredAndSortedStrings, actualFilteredAndSortedStrings);
    }

    @Test
    public void testFindPalindromeInRange() {
        int start = 100;
        int end = 200;
        List<Integer> expected = Arrays.asList(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);

        List<Integer> actual = StreamProcess.findPalindromeInRange(start, end);

        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToBinaryList() {
        List<Integer> numbers = Arrays.asList(5, 10, 15);
        List<String> expected = Arrays.asList("101", "1010", "1111");
        List<String> result = StreamProcess.convertToBinaryList(numbers);
        assertEquals(expected, result);
    }

}