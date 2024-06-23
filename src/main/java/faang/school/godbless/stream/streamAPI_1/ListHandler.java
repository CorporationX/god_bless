package faang.school.godbless.stream.streamAPI_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class ListHandler {
    public static List<Integer> integers =
            new ArrayList<>(List.of(1, 4, 9, 121, 45, 100, 22, 9, 0, -3, 2, -43, 1));
    public static List<String> strings =
            new ArrayList<>(List.of("word", "hello", "world", "good", "morning", "JAVA", "C++", "abracadbra"));

    public static int sumOfEvenIntegers(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxOfInteger(List<Integer> integers) {
        Optional<Integer> maxOfInteger = integers.stream()
                .max(Comparator.comparingInt(integer -> integer));
        return maxOfInteger.orElseThrow(() -> new NoSuchElementException("Максимальный элемент отсутствует"));
    }

    public static double findAverageOfInteger(List<Integer> integers) {
        OptionalDouble average = integers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return average.orElseThrow(() -> new NoSuchElementException("Среднее значение отсутствует"));
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortedByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isAllStringMatch(List<String> strings, Predicate<String> matcher) {
        return strings.stream()
                .allMatch(matcher);
    }

    public static int findMin(List<Integer> integers, int currentNumber) {
        OptionalInt min = integers.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > currentNumber)
                .min();
        return min.orElseThrow(() -> new NoSuchElementException("Наименьший элемент отсутствует"));
    }

    public static List<Integer> getLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
