package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        validList(numbers);
        Stream<Integer> integerStream = numbers.parallelStream();
        return integerStream.mapToInt(Integer::intValue).filter(number -> number % 2 == 0).sum();
    }

    public static int findMax(List<Integer> numbers) {
        validList(numbers);
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        return intStream.max().orElseThrow(() -> new IllegalArgumentException("Список не должен быть пустым"));
    }

    public static double findAverage(List<Integer> numbers) {
        validList(numbers);
        DoubleStream doubleStream = numbers.stream().mapToDouble(Integer::doubleValue);
        return doubleStream.average().orElseThrow(() -> new IllegalArgumentException("Список не должен быть пустым"));
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        validList(strings);
        return strings.stream().filter(string ->
                string.startsWith(String.valueOf(symbol))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        validArgument(substring);
        validList(strings);
        return strings.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        validList(strings);
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        validArgument(predicate);
        validList(numbers);
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int givenNumber) {
        validList(numbers);
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        return intStream.filter(number -> number > givenNumber).min()
                .orElseThrow(() -> new IllegalArgumentException("Список не должен быть пустым"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        validList(strings);
        return strings.stream().map(String::length).toList();
    }

    private static <T> void validList(List<T> list) {
        Objects.requireNonNull(list, "Список не должен быть null");
    }

    private static <U> void validArgument(U argument) {
        Objects.requireNonNull(argument, "Значение не должно быть null");
    }
}