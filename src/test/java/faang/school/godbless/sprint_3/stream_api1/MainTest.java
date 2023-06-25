package faang.school.godbless.sprint_3.stream_api1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();
    static List<Integer> plusNumberlist = List.of(1, 2, 3, 4, 5);
    static List<Integer> minusNumberList = List.of(-1, -2, -3, -4, -5);
    static List<String> list = List.of("!Hello hommie", "It's me Jimmy", "!Your Jimmy friend - friend ", "Do you remember me 15?", "Jimmy, I think you are not, hommie");

    @BeforeEach
    void init() {
    }

    @ParameterizedTest
    @MethodSource("calculateSumOfEvenNumbersMethod")
    void sumTest(List<Integer> list, int expected) {
        int result = main.calculateSumOfEvenNumbers(list);

        assertEquals(expected, result);
    }

    static Stream<Arguments> calculateSumOfEvenNumbersMethod() {
        return Stream.of(
                Arguments.of(plusNumberlist, 6),
                Arguments.of(minusNumberList, -6)
        );
    }

    @ParameterizedTest
    @MethodSource("findMaxElementMethod")
    void findMaxElementTest(List<Integer> list, int expected) {
        int result = main.findMaxElement(list);

        assertEquals(expected, result);
    }

    static Stream<Arguments> findMaxElementMethod() {
        return Stream.of(
                Arguments.of(plusNumberlist, 5),
                Arguments.of(minusNumberList, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("findAverageValueMethod")
    void findAverageValueTest(List<Integer> list, double expected) {
        double result = main.findAverageValue(list);

        assertEquals(expected, result);
    }

    static Stream<Arguments> findAverageValueMethod() {
        return Stream.of(
                Arguments.of(plusNumberlist, 3),
                Arguments.of(minusNumberList, -3.0)
        );
    }

    @ParameterizedTest
    @MethodSource("searchWordsInMethod")
    void searchWordsInTest(List<String> stringList, char value, List<String> expected) {
        List<String> result = main.searchWordsIn(stringList, value);

        assertEquals(expected, result);
    }

    static Stream<Arguments> searchWordsInMethod() {
        List<String> expected = List.of("!Hello hommie", "!Your Jimmy friend - friend ");
        List<String> secondExpected = List.of("Do you remember me 15?");
        return Stream.of(
                Arguments.of(list, '!', expected),
                Arguments.of(list, 'D', secondExpected)
        );
    }

    @ParameterizedTest
    @MethodSource("filterListMethod")
    void filterListTest(List<String> list, String substring, List<String> expected) {
        List<String> result = main.filterList(list, substring);

        assertEquals(expected, result);

    }

    static Stream<Arguments> filterListMethod() {
        List<String> expected = List.of("It's me Jimmy", "!Your Jimmy friend - friend ", "Jimmy, I think you are not, hommie");
        List<String> secondExpected = List.of("!Hello hommie", "Jimmy, I think you are not, hommie");
        return Stream.of(
                Arguments.of(list, "Jimmy", expected),
                Arguments.of(list, "hommie", secondExpected)
        );
    }

    @ParameterizedTest
    @MethodSource("filterByLengthMethod")
    void filterByLengthTest(List<String> list, List<String> expected) {
        List<String> result = main.filterByLength(list);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> filterByLengthMethod() {
        return Stream.of(
                Arguments.of(List.of("apple", "banana", "cherry"), List.of("banana", "cherry", "apple")),
                Arguments.of(List.of("one", "two", "three", "four"), List.of("three", "four", "one", "two")),
                Arguments.of(List.of("car", "bike", "bus"), List.of("bike", "car", "bus"))
        );
    }

    @ParameterizedTest
    @MethodSource("satisfyConditionMethod")
    <T> void satisfyConditionTest(List<T> list, Predicate<T> predicate, boolean expected) {
        boolean result = main.satisfyCondition(list, predicate);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> satisfyConditionMethod() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Predicate<String> firstPredicate = string -> !string.contains("Spam");
        Predicate<Integer> secondPredicate = value -> value <= 3;
        return Stream.of(
                Arguments.of(list, firstPredicate, true),
                Arguments.of(integers, secondPredicate, false)
        );
    }

    @ParameterizedTest
    @MethodSource("findSmallestElementAfterNumberMethod")
    void findSmallestElement(List<Integer> list, int value, int expected) {
        int result = main.findSmallestElementAfterNumber(list, value);

        assertEquals(expected, result);
    }

    static Stream<Arguments> findSmallestElementAfterNumberMethod() {
        return Stream.of(
                Arguments.of(plusNumberlist, 3, 4),
                Arguments.of(minusNumberList, -2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("convertListMethod")
    void convertListTest(List<String> stringList, List<Integer> expected) {
        List<Integer> result = main.convertList(stringList);

        assertEquals(expected, result);
    }

    static Stream<Arguments> convertListMethod() {
        return Stream.of(
                Arguments.of(list, List.of(13, 13, 28, 22, 34)),
                Arguments.of(List.of("table", "car", "wolf", "door", "home"), List.of(5, 3, 4, 4, 4))
        );
    }

    @Test
    void listValidationThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> main.listValidation(List.of()));
    }
}
