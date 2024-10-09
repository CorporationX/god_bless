package school.faang.godbless.bjs2_35493;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UtilsWithStreamApiTest {

    @ParameterizedTest
    @MethodSource("getNumbersForSumOfEven")
    @DisplayName("Testing getSumOfEvenNumbers with valid params")
    void testGetSumOfEvenNumbers(int expected, List<Integer> numbers) {
        assertEquals(expected, UtilsWithStreamApi.getSumOfEvenNumbers(numbers));
    }

    static Stream<Arguments> getNumbersForSumOfEven() {
        return Stream.of(
                arguments(10, List.of(5, 1, 2, 3, 8)),
                arguments(0, List.of(5, 1, 3)),
                arguments(14, List.of(2, 4, 8)),
                arguments(0, List.of())
        );
    }

    @Test
    @DisplayName("Testing getSumOfEvenNumbers with invalid params")
    void testGetSumOfEvenNumbersNull() {
        assertThrows(NullPointerException.class, () -> UtilsWithStreamApi.getSumOfEvenNumbers(null));
    }

    @ParameterizedTest
    @MethodSource("getNumbersForMax")
    @DisplayName("Testing getMaxNumber with valid params")
    void testGetMaxNumber(int expected, List<Integer> numbers) {
        assertEquals(expected, UtilsWithStreamApi.getMaxNumber(numbers));
    }

    static Stream<Arguments> getNumbersForMax() {
        return Stream.of(
                arguments(8, List.of(5, 1, 2, 3, 8)),
                arguments(5, List.of(5, 1, 3)),
                arguments(8, List.of(8)),
                arguments(8, List.of(8, 8, 8)),
                arguments(-8, List.of(-8, -20, -12)),
                arguments(20, List.of(-8, 20, -12))
        );
    }

    @Test
    @DisplayName("Testing getMaxNumber with invalid params")
    void testGetMaxNumberNullOrEmpty() {
        assertThrows(NullPointerException.class, () -> UtilsWithStreamApi.getMaxNumber(null));
        assertThrows(NoSuchElementException.class, () -> UtilsWithStreamApi.getMaxNumber(List.of()));
    }

    @ParameterizedTest
    @MethodSource("getNumbersForAverage")
    @DisplayName("Testing getAverage with valid params")
    void testGetAverage(int expected, List<Integer> numbers) {
        assertEquals(expected, UtilsWithStreamApi.getAverage(numbers));
    }

    static Stream<Arguments> getNumbersForAverage() {
        return Stream.of(
                arguments(3, List.of(5, 1, 2, 3, 8)),
                arguments(5, List.of(5, 5)),
                arguments(5, List.of(5)),
                arguments(0, List.of(-5, 5))
        );
    }

    @Test
    @DisplayName("Testing getAverage with invalid params")
    void testGetAverageWithInvalidParams() {
        assertThrows(NullPointerException.class, () -> UtilsWithStreamApi.getAverage(null));
        assertThrows(IllegalArgumentException.class, () -> UtilsWithStreamApi.getAverage(List.of()));
    }

    @ParameterizedTest
    @MethodSource("getWordsForCountStartsWith")
    @DisplayName("Testing countStartsWith with valid params")
    void testCountStartsWith(int expected, List<String> words, char symbol) {
        assertEquals(expected, UtilsWithStreamApi.countStartsWith(words, symbol));
    }

    static Stream<Arguments> getWordsForCountStartsWith() {
        return Stream.of(
                Arguments.of(1, List.of("word", "lord", "Word"), 'w'),
                Arguments.of(2, List.of("word", "we", "Word"), 'w'),
                Arguments.of(3, List.of("super", "soup", "siren"), 's'),
                Arguments.of(0, List.of(), 's')
        );
    }

    @Test
    @DisplayName("Testing countStartsWith with invalid params")
    void testCountStartsWithWhenInvalidParams() {
        assertThrows(NullPointerException.class, () -> UtilsWithStreamApi.countStartsWith(null, 's'));
    }

    @ParameterizedTest
    @MethodSource("getWordsForGetWordsContainingSubstring")
    @DisplayName("Testing getWordsContainingSubstring with valid params")
    void testGetWordsContainingSubstring(List<String> expected, List<String> words, String substring) {
        List<String> actual = UtilsWithStreamApi.getWordsContainingSubstring(words, substring);
        assertEquals(expected.size(), actual.size());
        expected.forEach(word -> assertTrue(actual.contains(word)));
    }

    static Stream<Arguments> getWordsForGetWordsContainingSubstring() {
        return Stream.of(
                Arguments.of(List.of("abac", "caba", "cabac"), List.of("caba", "abba", "abac", "cabac"), "aba"),
                Arguments.of(List.of(), List.of("aab", "abba"), "aba"),
                Arguments.of(List.of(), List.of(), "aba")
        );
    }

    @Test
    @DisplayName("Testing getWordsContainingSubstring with invalid params")
    void testGetWordsContainingSubstringInvalidParams() {
        assertThrows(NullPointerException.class, () -> UtilsWithStreamApi.getWordsContainingSubstring(null, "s"));
    }
}