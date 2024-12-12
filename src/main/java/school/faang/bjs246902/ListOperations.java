package school.faang.bjs246902;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return numbers.stream()
                .min(Comparator.reverseOrder())
                .orElse(Integer.MIN_VALUE);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Integer.MIN_VALUE);
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        if (strings == null || strings.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || strings.isEmpty()) {
            return new ArrayList<>();
        }
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return new ArrayList<>();
        }
        return strings.stream()
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        if (numbers == null || numbers.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return numbers.stream()
                .filter(n -> n > threshold)
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse(Integer.MIN_VALUE);
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return new ArrayList<>();
        }
        return strings.stream()
                .map(String::length)
                .toList();
    }
}