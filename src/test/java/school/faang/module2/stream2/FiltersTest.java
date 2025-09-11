package school.faang.module2.stream2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

class FiltersTest {

    @Test
    void filterCapitalsTest() {
        Map<String, String> countriesWithCapitals = Map.of(
                "Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"
        );

        List<String> capitals = Filters.filterCapitals(countriesWithCapitals);

        Assertions.assertEquals(capitals, List.of("Berlin", "Moscow", "Washington"));
    }

    @Test
    void filterStringsTest() {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");

        List<String> filtered = Filters.filterStrings(strings, 'a');

        Assertions.assertEquals(filtered, List.of("apple", "apricot", "avocado"));
    }

    @Test
    void mapIntsToBinaryTest() {
        List<Integer> ints = List.of(1, 2, 3, 4);

        List<String> binaryInts = Filters.mapIntsToBinary(ints);

        Assertions.assertEquals(binaryInts, List.of("1", "10", "11", "100"));
    }

    @Test
    void filterAllowedChars() {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape", "fsd123123");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> filtered = Filters.filterAllowedChars(strings, alphabet);


        Assertions.assertEquals(filtered, List.of("fig", "date", "apple", "grape", "banana", "cherry"));
    }

    @Test
    void findPairsTest() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 7;

        Set<Set<Integer>> pairs = Filters.findPairs(numbers, target);

        Assertions.assertTrue(pairs.contains(Set.of(1, 6)));
        Assertions.assertTrue(pairs.contains(Set.of(3, 4)));
        Assertions.assertTrue(pairs.contains(Set.of(2, 5)));
    }

}