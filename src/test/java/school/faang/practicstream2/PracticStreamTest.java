package school.faang.practicstream2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PracticStreamTest {
    PracticStream practicStream;

    @BeforeEach
    void setUp() {
        practicStream = new PracticStream();
    }

    @Test
    void sortNumbersByPairs() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        Set<List<Integer>> expected = Set.of(List.of(1, 5), List.of(2, 4));
        Integer num = 6;

        Set<List<Integer>> actual = practicStream.sortNumbersByPairs(numbers, num);

        assertEquals(expected, actual);
    }

    @Test
    void sortCountriesAndOutputCapitals() {
        Map<String, String> countris = Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin");
        List<String> expected = List.of("Berlin", "Moscow", "Washington");

        List<String> actual = practicStream.sortCountriesAndOutputCapitals(countris);

        assertEquals(expected, actual);
    }

    @Test
    void filterAndSortedString() {
        List<String> strings = List.of("apple", "banana", "avocados", "apricot");
        char ch = 'a';
        List<String> expected = List.of("apple", "apricot", "avocados");

        List<String> actual = practicStream.filterAndSortedString(strings, ch);

        assertEquals(expected, actual);
    }

    @Test
    void tarnsformationNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> expected = List.of("1", "10", "11", "100");

        List<String> actual = practicStream.tarnsformationNumbers(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void sortAlphabetically() {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");

        List<String> actual = practicStream.sortAlphabetically(strings, alphabet);

        assertEquals(expected, actual);
    }
}