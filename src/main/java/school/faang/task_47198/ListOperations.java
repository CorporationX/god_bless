package school.faang.task_47198;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("No elements"));
    }

    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char prefix) {
        return (int) strings.stream()
                .filter(str -> str.charAt(0) == prefix)
                .count();

    }

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allElementsMatch(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findSmallestGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(num -> num > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("No element greater than threshold"));
    }

    public static List<Integer> mapStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
