package school.faang.streamapione;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Input list must not be null or empty");
        }
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    public static double findAverage(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Input list must not be null or empty");
        }
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long countStringsStartingWith(List<String> strings, char firstChar) {
        if (strings == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == firstChar)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        if (strings == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return strings.stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> condition) {
        if (nums == null || condition == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }
        return nums.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> nums, int value) {
        if (nums == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return nums.stream()
                .filter(n -> n > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(String.format("No element greater than %d", value)));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
