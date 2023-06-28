package faang.school.godbless.lambda_stream.training_streamAPI_2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamMethodsTest {

    @Test
    void testUniqueNumbers() {
        List<Integer> nums = List.of(0, 1, 1, 2, 4, 4, 3, 5, 6, -1);
        Map<Integer, Integer> excepted = Map.of(0, 5, 1, 4, 2, 3, 6, -1);
        Map<Integer, Integer> actual = StreamMethods.uniqueNumbers(nums, 5);
        assertEquals(excepted, actual);
    }

    @Test
    void testSortCountriesAndCapitals() {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("United States", "Washington");
        countryCapitalMap.put("United Kingdom", "London");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Germany", "Berlin");
        List<String> excepted = List.of("Ottawa", "Berlin", "London", "Washington");
        List<String> actual = StreamMethods.sortCountriesAndCapitals(countryCapitalMap);
        assertEquals(excepted, actual);
    }

    @Test
    void testFilterStringByFirstLetter() {
        List<String> strings = List.of("architecture", "airplane", "animal", "adventure", "apple");
        List<String> excepted = List.of("apple", "animal", "airplane", "adventure", "architecture");
        List<String> actual = StreamMethods.filterStringByFirstLetter(strings, 'a');
        assertEquals(excepted, actual);
    }

    @Test
    void testMutualFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("John", List.of("Alice", "Bob", "Charlie"));
        friends.put("Alice", List.of("John", "Bob"));
        friends.put("Bob", List.of("John", "Alice", "Charlie"));
        friends.put("Charlie", List.of("John", "Bob"));
        Map<String, String> excepted = Map.of("Alice", "Charlie");
        Map<String, String> actual = StreamMethods.mutualFriends(friends);
        assertEquals(excepted, actual);
    }

    @Test
    void testAverageSalaryByDepartment() {
        List<Employee> employees = List.of(
                new Employee("Bob", "HR", 3000.0),
                new Employee("Bob", "HR", 3500.0),
                new Employee("Bob", "Sales", 4000.0),
                new Employee("Bob", "Sales", 4200.0),
                new Employee("Bob", "Sales", 5000.0)
        );
        Map<String, Double> excepted = Map.of("HR", 3250.0, "Sales", 4400.0);
        Map<String, Double> actual = StreamMethods.averageSalaryByDepartment(employees);
        assertEquals(excepted, actual);
    }

    @Test
    void testFilterByAlphabet() {
        String engAlphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> strings = List.of("apple", "123", "Bo$$", "Привет", "banana");
        List<String> excepted = List.of("apple", "banana");
        List<String> actual = StreamMethods.filterByAlphabet(strings, engAlphabet);
        assertEquals(excepted, actual);
    }

    @Test
    void testNumberToBinary() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        List<String> excepted = List.of("1", "10", "11", "100");
        List<String> actual = StreamMethods.numberToBinary(nums);
        assertEquals(excepted, actual);
    }

    @Test
    void testGetPalindromeNumbers() {
        List<Integer> excepted = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121);
        List<Integer> actual = StreamMethods.getPalindromeNumbers(10, 130);
        assertEquals(excepted, actual);
    }

    @Test
    void testGetPalindromeStrings() {
        List<String> excepted = List.of("Tenet", "Level", "Bob");
        List<String> actual = StreamMethods.getPalindromeStrings("Hello Tenet abc Level qwe Bob ewq");
        assertEquals(excepted, actual);
    }

    @Test
    void testGetPerfectNumbers() {
        List<Integer> excepted = List.of(6, 28, 496);
        List<Integer> actual = StreamMethods.getPerfectNumbers(1, 1000);
        assertEquals(excepted, actual);
    }
}