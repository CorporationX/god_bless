package faang.school.godbless.streamapi2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiExercisesTest {

    @Test
    void findTargetSumPairs() {
        List<List<Integer>> expected = List.of(List.of(1, 9), List.of(4, 6));
        List<List<Integer>> actual = StreamApiExercises.findTargetSumPairs(List.of(1, 1, 3, 12, 4, 5, 9, 6), 10);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getCountriesCapitals() {
        Map<String, String> countryCapitals = new HashMap<>();

        countryCapitals.put("United States", "Washington");
        countryCapitals.put("Canada", "Ottawa");
        countryCapitals.put("United Kingdom", "London");
        countryCapitals.put("Germany", "Berlin");
        countryCapitals.put("France", "Paris");
        countryCapitals.put("Italy", "Rome");
        countryCapitals.put("Japan", "Tokyo");
        countryCapitals.put("Australia", "Canberra");
        countryCapitals.put("India", "New Delhi");
        countryCapitals.put("China", "Beijing");

        List<String> expected = List.of(
                "Canberra", // Australia
                "Ottawa", // Canada
                "Beijing", // China
                "Paris", // France
                "Berlin", // Germany
                "New Delhi", // India
                "Rome", // Italy
                "Tokyo", // Japan
                "London", // United Kingdom
                "Washington" // United States
        );
        List<String> actual = StreamApiExercises.getCountriesCapitals(countryCapitals);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getStringsStartingWithChar() {
        List<String> expected = List.of("Sort by length", "Short short sentence");
        List<String> actual = StreamApiExercises.getStringsStartingWithChar(
                List.of("I am here", "Hello world", "Short short sentence", "Java Streams", "Sort by length"),
                's'
        );

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getMutualFriendsPairs() {
        Map<String, List<String>> friends = new HashMap<>();

        friends.put("Kolya", List.of("Dima", "Petya", "Oleg", "Sveta"));
        friends.put("Masha", List.of("Dima", "Oleg", "Sveta", "Anna"));
        friends.put("Ivan", List.of("Vasya", "Anna", "Lena"));
        friends.put("Lena", List.of("Vasya", "Petya", "Ivan"));

        List<List<String>> expected = List.of(List.of("Kolya", "Masha"), List.of("Ivan", "Masha"), List.of("Kolya", "Lena"));
        List<List<String>> actual = StreamApiExercises.getMutualFriendsPairs(friends);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getAverageSalaryByDepartment() {
        Employee employee1 = new Employee("Alice", 75000, "Engineering");
        Employee employee2 = new Employee("Bob", 85000, "Engineering");
        Employee employee3 = new Employee("Charlie", 95000, "Marketing");
        Employee employee4 = new Employee("David", 55000, "Sales");
        Employee employee5 = new Employee("Eve", 105000, "Engineering");
        Employee employee6 = new Employee("Frank", 65000, "Marketing");

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Engineering", 88333);
        expected.put("Marketing", 80000);
        expected.put("Sales", 55000);
        Map<String, Integer> actual = StreamApiExercises.getAverageSalaryByDepartment(employees);

        assertEquals(expected, actual);
    }

    @Test
    void filterStringsByAlphabet() {
        List<String> expected = List.of("dog", "cat", "apple", "banana");
        List<String> actual = StreamApiExercises.filterStringsByAlphabet(
                List.of("apple", "banana", "123", "dog", "cat"),
                "abcdefghijklmnopqrstuvwxyz"
        );

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void convertIntegersToBinaryStrings() {
        List<String> expected = List.of("1", "1111", "11");
        List<String> actual = StreamApiExercises.convertIntegersToBinaryStrings(List.of(1, 15, 3));

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void findIntegerPalindromes() {
        List<Integer> expected = List.of(11, 22, 33);
        List<Integer> actual = StreamApiExercises.findIntegerPalindromes(0, 40);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void findPalindromesWithinString() {
        List<String> expected = List.of("aba", "ababa", "bab", "babab");
        List<String> actual = StreamApiExercises.findPalindromesWithinString("ababab");

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void getPerfectNumbersWithinRange() {
        List<Integer> expected = List.of(6, 28, 496);
        List<Integer> actual = StreamApiExercises.getPerfectNumbersWithinRange(6, 600);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}