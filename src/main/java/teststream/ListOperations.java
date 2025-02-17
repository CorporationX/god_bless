package teststream;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null.");
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null.");
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List of numbers is empty."));
    }

    public static double findAverage(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null.");
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        Objects.requireNonNull(strings, "List of strings cannot be null.");
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> findStringsContainingSubstring(List<String> strings, String substring) {
        Objects.requireNonNull(strings, "List of strings cannot be null.");
        Objects.requireNonNull(substring, "Substring cannot be null.");
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        Objects.requireNonNull(strings, "List of strings cannot be null.");
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null.");
        Objects.requireNonNull(condition, "Predicate cannot be null.");
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        Objects.requireNonNull(numbers, "List of numbers cannot be null.");
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("No number greater than %d found in the list: %s", threshold, numbers)
                ));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        Objects.requireNonNull(strings, "List of strings cannot be null.");
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
