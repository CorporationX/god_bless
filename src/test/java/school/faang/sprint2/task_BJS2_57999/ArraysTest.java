package school.faang.sprint2.task_BJS2_57999;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    @Test
    public void findUniqueSumOfNumbersEqualTarget() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Map<Integer, Integer> uniqueSumOfNumbers = Map.of(1, 5, 2, 4);
        int target = 6;
        assertEquals(uniqueSumOfNumbers, Arrays.findUniqueSumOfNumbersEqualTarget(numbers, target));
    }

    @Test
    public void getCitySortedByCountry() {
        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        Set<String> sortedCities = Set.of("Berlin", "Moscow", "Washington");
        assertEquals(sortedCities, Arrays.getCitySortedByCountry(countries));
    }

    @Test
    public void getSortedStringsStartsWithChar() {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot", "cherry", "date", "fig");
        List<String> sortedStrings = List.of("apple", "avocado", "apricot");
        char start = 'a';
        assertEquals(sortedStrings, Arrays.getSortedStringsStartsWithChar(strings, start));
    }

    @Test
    public void convertToBinaryStrings() {
        List<Integer> listOfInteger = List.of(1, 2, 3, 4);
        List<String> binaryString = List.of("1", "10", "11", "100");
        assertEquals(binaryString, Arrays.convertToBinaryStrings(listOfInteger));
    }

    @Test
    public void getFilteredByAlphabetAndSortByLength() {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> excepted = List.of("fig", "date", "apple", "grape", "banana", "cherry");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        assertEquals(excepted, Arrays.getFilteredByAlphabetAndSortByLength(strings, alphabet));
    }

}