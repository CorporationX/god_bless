package faang.school.godbless.stream_practise2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamPractiseTest {

    @Test
    void testFindUniqueNumberPairsWithSum() {
        List<String> actualOutput = StreamPractise.findUniqueNumberPairsWithSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10);
        List<String> expectedOutput = List.of("1 + 9", "2 + 8", "3 + 7", "4 + 6");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSortAlphabeticallyCountriesNames() {
        Map<String, String> countries = new HashMap<>();
        countries.put("America", "Washington");
        countries.put("Britain", "London");
        countries.put("Italy", "Rome");
        countries.put("Canada", "Ottawa");

        List<String> actualOutput = StreamPractise.sortAlphabeticallyCountriesNames(countries);
        List<String> expectedOutput = List.of("Washington", "London", "Ottawa", "Rome");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFilterAndSortStringsByStartingLetter() {
        List<String> actualOutput = StreamPractise.filterAndSortStringsByStartingLetter(
                List.of("apple", "banana", "avocado", "pear", "melon", "pineapple"), 'a');
        List<String> expectedOutput = List.of("apple", "avocado");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFindNonFriendPairsWithCommonFriends() {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", List.of("Bob", "Charlie", "David"));
        friendsMap.put("Bob", List.of("Alice", "Eve"));
        friendsMap.put("Charlie", List.of("Alice", "David"));
        friendsMap.put("David", List.of("Alice", "Charlie"));
        friendsMap.put("Eve", List.of("Bob"));

        List<List<String>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of("Bob", "Charlie"));
        expectedOutput.add(List.of("Bob", "David"));
        expectedOutput.add(List.of("Alice", "Eve"));

        List<List<String>> actualOutput = StreamPractise.findNonFriendPairsWithCommonFriends(friendsMap);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGetAverageSalaryForDepartment() {
        Employee employee1 = new Employee("John", "Sales", 5000);
        Employee employee2 = new Employee("Alice", "Sales", 6000);
        Employee employee3 = new Employee("Bob", "HR", 4000);
        Employee employee4 = new Employee("Charlie", "HR", 4500);

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4);

        Map<String, Double> expected = new HashMap<>();
        expected.put("Sales", 5500.0);
        expected.put("HR", 4250.0);

        Map<String, Double> actual = StreamPractise.getAverageSalaryForDepartment(employees);

        assertEquals(expected, actual);
    }

    @Test
    void testFilterAndSortStrings() {
        List<String> strings = List.of("apple", "123", "banana", "cherry", "dog", "elephant");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> actualOutput = StreamPractise.filterAndSortStrings(strings, alphabet);
        List<String> expectedOutput = List.of("dog", "apple", "banana", "cherry", "elephant");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testConvertToBinaryList() {
            List<Integer> integers = List.of(10, 5, 3);

            List<String> actualOutput = StreamPractise.convertToBinaryList(integers);
            List<String> expectedOutput = List.of("1010", "101", "11");

            assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void testFindPalindromeNumbers() {
        int start = 1;
        int end = 100;

        List<Integer> actualOutput = StreamPractise.findPalindromeNumbers(start, end);
        List<Integer> expectedOutput = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99);

        assertEquals(expectedOutput, actualOutput);
    }
}
