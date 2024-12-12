package school.faang.bjs_47121;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOperations2Test {

    public static Stream<Arguments> getNumbersAndSum() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7,
                        Map.of(1, 6, 2, 5, 3, 4))
        );
    }

    public static Stream<Arguments> getCountries() {
        return Stream.of(
                Arguments.of(Map.of("Russia", "Moscow", "USA", "Washington",
                        "Germany", "Berlin"), Arrays.asList("Berlin", "Moscow", "Washington"))
        );
    }

    public static Stream<Arguments> getStringsAndLetter() {
        return Stream.of(
                Arguments.of(Arrays.asList("apple", "banana", "avocado", "apricot"), 'a',
                        Arrays.asList("apple", "avocado", "apricot"))
        );
    }

    public static Stream<Arguments> getNumbersAndBinaryStrings() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4), Arrays.asList("1", "10", "11", "100"))
        );
    }

    public static Stream<Arguments> getStringsAndFilter() {
        return Stream.of(
                Arguments.of(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz",
                        Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry"))
        );
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndSum")
    void getPairOfNumbers(List<Integer> numbers, int sum, Map<Integer, Integer> expected) {
        assertEquals(expected, ListOperations2.getPairOfNumbers(numbers, sum));
    }

    @ParameterizedTest
    @MethodSource("getCountries")
    void getCapitals(Map<String, String> countries, List<String> expected) {
        assertEquals(expected, ListOperations2.getCapitals(countries));
    }

    @ParameterizedTest
    @MethodSource("getStringsAndLetter")
    void getFilteredAndSortedStrings(List<String> strings, char letter, List<String> expected) {
        assertEquals(expected, ListOperations2.getFilteredAndSortedStrings(strings, letter));
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndBinaryStrings")
    void getNumbersInBinary(List<Integer> numbers, List<String> expected) {
        assertEquals(expected, ListOperations2.getNumbersInBinary(numbers));
    }

    @ParameterizedTest
    @MethodSource("getStringsAndFilter")
    void getFilteredAndSortedStrings(List<String> strings, String filterString, List<String> expected) {
        assertEquals(expected, ListOperations2.getFilteredAndSortedStrings(strings, filterString));
    }
}