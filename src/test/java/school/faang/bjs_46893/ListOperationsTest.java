package school.faang.bjs_46893;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ListOperationsTest {

    private static Stream<Arguments> getNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 12),
                Arguments.of(Arrays.asList(1, 3, 4, 5, 6), 10),
                Arguments.of(Arrays.asList(1, 3, 5), 0),
                Arguments.of(List.of(2), 2),
                Arguments.of(List.of(1), 0),
                Arguments.of(List.of(0), 0)
        );
    }

    private static Stream<Arguments> getNumbersForMaxTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 3, 5), 5),
                Arguments.of(List.of(2), 2),
                Arguments.of(List.of(1), 1),
                Arguments.of(List.of(0), 0)
        );
    }

    private static Stream<Arguments> getNumbersForAvgTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 3.5),
                Arguments.of(Arrays.asList(1, 3, 4, 5, 6), 3.8),
                Arguments.of(Arrays.asList(1, 3, 5), 3),
                Arguments.of(List.of(2), 2),
                Arguments.of(List.of(1), 1),
                Arguments.of(List.of(0), 0)
        );
    }

    private static Stream<Arguments> getStrings() {
        return Stream.of(
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), 'A', 2),
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), 'a', 1),
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), 'b', 0)
        );
    }

    private static Stream<Arguments> getStringWithSubstring() {
        return Stream.of(
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), "Add",
                        List.of("Add oor")),
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), "aA",
                        Arrays.asList("BaA ds", "aAAA_bbb")),
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"), "CaA",
                        List.of())
        );
    }

    public static Stream<Arguments> getStringsBySort() {
        return Stream.of(
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"),
                        Arrays.asList("BaA ds", "Aaa bbb", "Add oor", "aAAA_bbb")),
                Arguments.of(Arrays.asList("Aaa bbb", "ZxZ", "BaA ds", "Add oor", "aAAA_bbb"),
                        Arrays.asList("ZxZ", "BaA ds", "Aaa bbb", "Add oor", "aAAA_bbb"))
        );
    }

    public static Stream<Arguments> getNumbersAndPredicate() {
        Predicate<Integer> predicate1 = x -> x > 0;
        Predicate<Integer> predicate2 = x -> x % 2 == 0;
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), predicate1, true),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), predicate2, false),
                Arguments.of(Arrays.asList(12, 2, 10, 4, 8, 6), predicate2, true)
        );
    }

    public static Stream<Arguments> getNumbersAndComparedNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 2, 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1, 2),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 5, 6)
        );
    }

    public static Stream<Arguments> getStringsAndLengths() {
        return Stream.of(
                Arguments.of(Arrays.asList("Aaa bbb", "BaA ds", "Add oor", "aAAA_bbb"),
                        Arrays.asList(7, 6, 7, 8)),
                Arguments.of(Arrays.asList("Aaa  bbb", "BaA", "Add oor", "aAAA_bbb"),
                        Arrays.asList(8, 3, 7, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("getNumbers")
    void sumEvenNumbers(List<Integer> numbers, int expected) {
        assertEquals(expected, ListOperations.sumEvenNumbers(numbers));
    }

    @ParameterizedTest
    @MethodSource("getNumbersForMaxTest")
    void maxNumbers(List<Integer> numbers, int expected) {
        assertEquals(expected, ListOperations.maxNumbers(numbers));
    }

    @ParameterizedTest
    @MethodSource("getNumbersForAvgTest")
    void avgNumber(List<Integer> numbers, double expected) {
        assertEquals(expected, ListOperations.avgNumber(numbers));
    }

    @ParameterizedTest
    @MethodSource("getStrings")
    void countStartWith(List<String> strings, char letter, int expected) {
        assertEquals(expected, ListOperations.countStartWith(strings, letter));
    }

    @ParameterizedTest
    @MethodSource("getStringWithSubstring")
    void containsSubstring(List<String> strings, String substring, List<String> expected) {
        assertEquals(expected, ListOperations.containsSubstring(strings, substring));
    }

    @ParameterizedTest
    @MethodSource("getStringsBySort")
    void sort(List<String> strings, List<String> expected) {
        assertEquals(expected, ListOperations.sortByLength(strings));
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndPredicate")
    void validate(List<Integer> numbers, Predicate<Integer> predicate, boolean expected) {
        boolean actual = ListOperations.validate(numbers, predicate);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getNumbersAndComparedNumber")
    void findMinGreatThan(List<Integer> numbers, int comparedNumber, int expected) {
        assertEquals(expected, ListOperations.findMinGreatThan(numbers, comparedNumber));
    }

    @Test
    void findMinGreatThanWithError() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int comparedNumber = 6;
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findMinGreatThan(numbers, comparedNumber),
                "No number found");
    }

    @ParameterizedTest
    @MethodSource("getStringsAndLengths")
    void getStringsLengths(List<String> strings, List<Integer> expected) {
        assertEquals(expected, ListOperations.getStringsLengths(strings));
    }
}