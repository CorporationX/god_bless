package faang.school.godbless.BJS2_22550;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StreamsTest {

    @Test
    public void testFindPairsWithX() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int x = 5;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(2, 3));
        List<List<Integer>> result = Streams.findPairsWithX(numbers, x);
        assertEquals(expected, result);
    }

    @Test
    public void testFilterCountryByCapital() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("France", "Paris");
        countries.put("Germany", "Berlin");

        List<String> expected = Arrays.asList("Paris", "Berlin", "Moscow");
        List<String> result = Streams.filterCountryByCapital(countries);
        assertEquals(expected, result);
    }

    @Test
    public void testFilterStringByX() {
        List<String> stringList = Arrays.asList("apple", "banan", "cherry", "avocado");
        char x = 'a';
        List<String> expected = Arrays.asList("apple", "avocado");
        List<String> result = Streams.filterStringByX(stringList, x);
        assertEquals(expected, result);
    }

    @Test
    public void testFindNoFriends() {
        Map<String, List<String>> mapOfFriendsList = new HashMap<>();

        mapOfFriendsList.put("Sasha", Arrays.asList("Masha", "Petya"));
        mapOfFriendsList.put("Masha", Arrays.asList("Sasha", "Tanya"));
        mapOfFriendsList.put("Petya", Arrays.asList("Sasha", "Tanya"));
        mapOfFriendsList.put("Tanya", Arrays.asList("Masha", "Petya"));

        List<List<String>> result = Streams.findNoFriends(mapOfFriendsList);

        assertTrue(result.contains(Arrays.asList("Sasha", "Tanya")));
        assertTrue(result.contains(Arrays.asList("Masha", "Petya")));
    }

    @Test
    public void testFindDepartmentWithAverageSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("Sasha", 3000, "HR"),
                new Employee("Petya", 3500, "IT"),
                new Employee("Masha", 4000, "IT")
        );
        Map<String, Double> expected = new HashMap<>();
        expected.put("HR", 3000.0);
        expected.put("IT", 3750.0);

        Map<String, Double> result = Streams.findDepartmentWithAverageSalary(employees);
        assertEquals(expected, result);
    }

    @Test
    public void testFilterAndSortingStrings() {
        List<String> stringList = Arrays.asList("banan", "cherry", "egg");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = Arrays.asList("egg", "banan", "cherry" );

        List<String> result = Streams.filterAndSortingStrings(stringList, alphabet);
        assertEquals(expected, result);
    }

    @Test
    public void testIntegersToBinaryViewStrings() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");

        List<String> result = Streams.integersToBinaryViewStrings(integerList);
        assertEquals(expected, result);
    }

    @Test
    public void testFindPalindromesInRange() {
        int start = 10;
        int end = 100;
        List<Integer> expected = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99);

        List<Integer> result = Streams.findPalindromesInRange(start, end);
        assertEquals(expected, result);
    }
}