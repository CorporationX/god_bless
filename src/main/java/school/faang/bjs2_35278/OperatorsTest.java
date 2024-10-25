package school.faang.bjs2_35278;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorsTest {

    @Test
    public void testUniqPairs() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int target = 7;


        Set<List<Integer>> expectedPairs = new HashSet<>(Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        ));


        List<int[]> resultPairs = Operators.uniqPairs(numbers, target);
        Set<List<Integer>> actualPairs = new HashSet<>();
        for (int[] pair : resultPairs) {
            actualPairs.add(Arrays.asList(pair[0], pair[1]));
        }


        assertEquals(expectedPairs, actualPairs);
    }

    @Test
    public void testCountriesCapitals() {
        Map<String, String> countriesCapitals = new HashMap<>();
        countriesCapitals.put("Russia", "Moscow");
        countriesCapitals.put("USA", "Washington");
        countriesCapitals.put("Germany", "Berlin");

        List<String> expectedCapitals = Arrays.asList("Berlin", "Moscow", "Washington");
        List<String> resultCapitals = Operators.countriesCapitals(countriesCapitals);

        assertEquals(expectedCapitals, resultCapitals);
    }

    @Test
    public void testSortedAndFiltered() {
        List<String> listOfNames = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';

        List<String> expected = Arrays.asList("apple", "avocado", "apricot");
        List<String> result = Operators.sortedAndFiltered(listOfNames, startChar);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertToBinary() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> expectedBinary = Arrays.asList("1", "10", "11", "100");

        List<String> result = Operators.convertToBinary(numbers);

        assertEquals(expectedBinary, result);
    }

    @Test
    public void testFilteredAndSorted() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "fig", "date", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> expected = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");
        List<String> result = Operators.filteredAndSorted(words, alphabet);

        assertEquals(expected, result);
    }
}
