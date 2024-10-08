package school.faang.stream.api.two;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamApiTwoServiceTest {

    @Test
    public void findUniquePairsOfNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        );

        List<List<Integer>> result = StreamApiTwoService.findUniquePairsOfNumbers(numbers, target);

        assertEquals(expected, result);
    }

    @Test
    public void sortCountriesAndGetCapitalsTest() {
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> expected = Arrays.asList("Berlin", "Moscow", "Washington");

        List<String> result = StreamApiTwoService.sortCountriesAndGetCapitals(countries);

        assertEquals(expected, result);
    }

    @Test
    public void sortAndFilterRowsByCharTest() {
        List<String> rows = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> expected = Arrays.asList("apple", "apricot", "avocado");

        List<String> result = StreamApiTwoService.sortAndFilterRowsByChar(rows, 'a');

        assertEquals(expected, result);
    }

    @Test
    public void convertToBinaryTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> expected = Arrays.asList("1", "10", "11", "100");

        List<String> result = StreamApiTwoService.convertToBinary(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void sortAndFilterRowsByAlphabetTest() {
        List<String> rows = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");

        List<String> result = StreamApiTwoService.sortAndFilterRowsByAlphabet(rows, alphabet);

        assertEquals(expected, result);
    }
}