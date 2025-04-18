package school.faang.streamapione;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMax(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find max of an empty list!"));
    }

    public static double getAverage(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Cannot calculate average of an empty list!"));
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char firstChar) {
        return strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == firstChar)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, String subString) {
        return strings.stream()
                .filter(s -> s.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(@NonNull List<Integer> nums, @NonNull Predicate<Integer> condition) {
        return nums.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> nums, int value) {
        return nums.stream()
                .filter(n -> n > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(String.format("No element greater than %d", value)));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
