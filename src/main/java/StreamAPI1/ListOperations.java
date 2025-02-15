package StreamAPI1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty!"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty!"));

    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings == null
                ? 0
                : strings.stream()
                .filter(s -> s != null && s.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings == null || subString == null ? Collections.emptyList()
                : strings.stream()
                .filter(s -> s != null && s.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings == null
                ? Collections.emptyList()
                : strings.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        if (numbers == null) {
            throw new IllegalArgumentException("List cannot be null!");
        }

        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int limit) {
        if (numbers == null) {
            throw new IllegalArgumentException("List cannot be null!");
        }

        return numbers.stream()
                .filter(num -> num != null && num > limit)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("There are no numbers greater than " + limit + " !"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings == null
                ? Collections.emptyList()
                : strings.stream()
                .map(String::length)
                .toList();
    }
}
