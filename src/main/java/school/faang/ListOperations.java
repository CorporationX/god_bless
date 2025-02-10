package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        validateList(numbers);
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        validateList(numbers);
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty."));
    }

    public static double findAverage(List<Integer> numbers) {
        validateList(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char start) {
        validateList(strings);
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == start)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        validateList(strings);
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        validateList(strings);
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        validateList(numbers);
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        validateList(numbers);
        return numbers.stream()
                .filter(num -> num > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new NoSuchElementException("There are no elements greater than " + threshold + " ."));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        validateList(strings);
        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static <T> void validateList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List can't be null.");
        }
        for (T entry : list) {
            if (entry == null) {
                throw new IllegalArgumentException("The value in list can't be null.");
            }
        }
    }
}
