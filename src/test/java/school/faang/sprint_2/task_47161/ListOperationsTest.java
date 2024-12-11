package school.faang.sprint_2.task_47161;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOperationsTest {
    static List<Integer> numbers;
    static Map<String, String> countriesCity;
    static List<String> strings;
    static List<String> anotherStrings;
    static String alphabet;

    @BeforeAll
    public static void beforeAll() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        countriesCity = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        strings = List.of("apple", "banana", "avocado", "apricot");
        anotherStrings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    @Test
    public void test() {
        System.out.println(ListOperations.findPairOfNumbers(numbers, 7));
        System.out.println(ListOperations.sortCapitals(countriesCity));
        System.out.println(ListOperations.filterAndSortStrings(strings, 'a'));
        System.out.println(ListOperations.convertToBinary(numbers));
        System.out.println(ListOperations.filterAndSortByLength(anotherStrings, alphabet));
    }

    @Test
    public void findPairOfNumbersTest() {
        Set<List<Integer>> expected = Set.of(List.of(3, 4), List.of(2, 5), List.of(1, 6));
        Set<List<Integer>> result = ListOperations.findPairOfNumbers(numbers, 7);

        assertEquals(expected, result);
    }

    @Test
    public void sortCapitalsTest() {
        List<String> expected = List.of("Berlin", "Moscow", "Washington");
        List<String> result = ListOperations.sortCapitals(countriesCity);

        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortStringsTest() {
        List<String> expected = List.of("apple", "avocado", "apricot");
        List<String> result = ListOperations.filterAndSortStrings(strings, 'a');

        assertEquals(expected, result);
    }

    @Test
    public void convertToBinaryTest() {
        List<String> expected = List.of("1", "10", "11", "100", "101", "110");
        List<String> result = ListOperations.convertToBinary(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void filterAndSortByLengthTest() {
        List<String> expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");
        List<String> result = ListOperations.filterAndSortByLength(anotherStrings, alphabet);

        assertEquals(expected, result);
    }

}
