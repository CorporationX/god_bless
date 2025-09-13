package school.faang.сollection__stream_api__optional.bjs2_88054;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                // .reduce(0, (a, b) -> a + b); //старый вариант
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max((a, b) -> a - b)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(x -> x)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static long countStringsStartingWith(List<String> strings, char startingChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startingChar)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(x -> x.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((a, b) -> a.length() - b.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(x -> x > value)
                .min((x, y) -> x - y)
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
