package faang.school.godbless.sprint3.streams.treaningStreamAPI.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTrainingTest {

    @ParameterizedTest
    @MethodSource("getIntsForEvenTest")
    @DisplayName("Сумма четных чисел если они есть")
    void getSumOfEvenNumbers_testWithEvenNumbers(int expected, int[] ints) {
        assertEquals(expected, StreamApiTraining.getSumOfEvenNumbers(ints));
    }

    @ParameterizedTest
    @MethodSource("getIntsWithoutEvenNumber")
    @DisplayName("Сумма четных чисел если их нет")
    void getSumOfEvenNumbers_testWithoutEvenNumbers(int expected, int[] ints) {
        assertEquals(expected, StreamApiTraining.getSumOfEvenNumbers(ints));
    }

    @ParameterizedTest
    @MethodSource("getIntsForMaxNumber")
    @DisplayName("Поиск максимального числа")
    void getMaxNumber_testWithNumbers(int expected, int[] ints) {
        OptionalInt optionalResult = StreamApiTraining.getMaxNumber(ints);
        if (optionalResult.isPresent()) {
            assertEquals(expected, optionalResult.getAsInt());
        }
    }

    @Test
    @DisplayName("Поиск максимального числа: если массив пустой")
    void getMaxNumber_testWithNumbers() {
        assertFalse(StreamApiTraining.getMaxNumber(new int[]{}).isPresent());
    }

    @ParameterizedTest
    @MethodSource("getDoubleArrayForAverage")
    @DisplayName("Поиск среднего")
    void getAverageOfNumbers_test(double expected, int[] ints) {
        OptionalDouble optionalResult = StreamApiTraining.getAverageOfNumbers(ints);
        if (optionalResult.isPresent()) {
            assertEquals(expected, optionalResult.getAsDouble());
        }
    }

    @ParameterizedTest
    @MethodSource("getStringAndChar")
    @DisplayName("Получение количества строк начинающихся с символа")
    void getNumberOfLinesStartingWith_test(long expected, String[] strings, char symbol) {
        assertEquals(expected, StreamApiTraining.getNumberOfLinesStartingWith(strings, symbol));
    }

    private static Stream<Arguments> getIntsForEvenTest() {
        return Stream.of(
                Arguments.of(6, new int[]{2, 4}),
                Arguments.of(2, new int[]{2, 3, 5}),
                Arguments.of(8, new int[]{2, 2, 2, 3, 2}),
                Arguments.of(10, new int[]{4, 6, 1})
        );
    }

    private static Stream<Arguments> getIntsWithoutEvenNumber() {
        return Stream.of(
                Arguments.of(0, new int[]{1, 3}),
                Arguments.of(0, new int[]{19, 13, 5}),
                Arguments.of(0, new int[]{101, 23, 21, 3, 29}),
                Arguments.of(0, new int[]{41, 61, 1})
        );
    }

    private static Stream<Arguments> getIntsForMaxNumber() {
        return Stream.of(
                Arguments.of(3, new int[]{1, 3}),
                Arguments.of(19, new int[]{19, 13, 5}),
                Arguments.of(101, new int[]{101, 23, 21, 3, 29}),
                Arguments.of(61, new int[]{41, 61, 1})
        );
    }

    private static Stream<Arguments> getDoubleArrayForAverage() {
        return Stream.of(
                Arguments.of(2.0, new int[]{1, 3}),
                Arguments.of(8.0, new int[]{10, 12, 2}),
                Arguments.of(10, new int[]{10, 10, 10, 10}),
                Arguments.of(0, new int[]{-1, 1})
        );
    }

    private static Stream<Arguments> getStringAndChar() {
        return Stream.of(
                Arguments.of(2, new String[]{"home", "hour", "joy"}, 'h'),
                Arguments.of(0, new String[]{"home", "hour", "joy"}, 'l'),
                Arguments.of(3, new String[]{"memory", "minute", "nmon", "mouse", "not"}, 'm')
        );
    }
}