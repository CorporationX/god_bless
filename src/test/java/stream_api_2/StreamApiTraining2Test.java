package stream_api_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stream_api_2.StreamApiTraining2.alphabetContains;

public class StreamApiTraining2Test {
    private List<Integer> numbers;
    private Map<String, String> countries;
    private List<String> strings;
    private char letter;
    private Map<String, List<String>> people;
    private List<Employee> employees;
    private List<String> alphabetStrings;

    @BeforeEach
    public void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5);
        countries = new HashMap<>();
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        countries.put("Italy", "Rome");
        strings = Arrays.asList("apple", "banana", "cherry");
        letter = 'b';
        people = new HashMap<>();
        people.put("Alice", Arrays.asList("Bob", "Carol"));
        people.put("Bob", Arrays.asList("Alice", "Dave"));
        people.put("Carol", Arrays.asList("Alice", "Eve"));
        employees = Arrays.asList(
                new Employee("John", 5000.0, "HR"),
                new Employee("Alice", 6000.0, "IT"),
                new Employee("Bob", 4000.0, "HR")
        );
        alphabetStrings = Arrays.asList("apple", "ball", "cat", "dog");
    }

    @Test
    public void testFindPairs() {
        List<Integer> list = List.of(2, 5, 7, 1, 3, 9, 6, 8, 4, 0, 2, 4, 0, 3, 1);

        Map<Integer, Integer> pairs = StreamApiTraining2.findPairs(list, 4);

        assertEquals(Map.of(1, 3, 2, 2, 4, 0), pairs);
    }

    @Test
    public void testSortCountries() {
        List<String> expected = Arrays.asList("Paris", "Berlin", "Rome");
        assertEquals(expected, StreamApiTraining2.sortCountries(countries));
    }

    @Test
    public void testFilterAndSortString() {
        List<String> expected = Arrays.asList("banana");
        assertEquals(expected, StreamApiTraining2.filterAndSortString(strings, letter));
    }

    @Test
    public void testAverageSalaryByDepartment() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("HR", 4500.0);
        expected.put("IT", 6000.0);
        assertEquals(expected, StreamApiTraining2.averageSalaryByDepartment(employees));
    }

    @Test
    public void testFilterAndSortAlphabetStrings() {
        String str = "abc";
        String str1 = "cba a b b";
        String str2 = "aaa";
        String str3 = "";
        String str4 = "WaNg";
        List<String> list = List.of(str, str1, str2, str3, str4);
        String alphabet = "abc";

        List<String> result = alphabetContains(list, alphabet);

        assertEquals(List.of("abc", "aaa", "cba a b b"), result);
    }

    @Test
    public void testConvertToBinary() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        assertEquals(expected, StreamApiTraining2.convertToBinary(input));
    }

    @Test
    public void testFindPalindromicNumbers() {
        List<Integer> expected = Arrays.asList(22, 33, 44);
        assertEquals(expected, StreamApiTraining2.findPalindromicNumbers(20, 50));
    }

    @Test
    public void testFindPerfectNumbers() {
        List<Integer> expected = Arrays.asList(6);
        assertEquals(expected, StreamApiTraining2.findPerfectNumbers(1, 10));
    }
}
