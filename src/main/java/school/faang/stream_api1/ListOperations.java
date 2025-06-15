package school.faang.stream_api1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> nums) {
        Optional<Integer> result = nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum);

        return result.orElse(0);
    }

    public static int sumInt1(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> filter) {
        return nums.stream()
                .anyMatch(num -> !filter.test(num));
    }

    public static int findMinGreaterThan(List<Integer> nums, int min) {
        return nums.stream().mapToInt(Integer::intValue)
                .filter(num -> num > min)
                .min()
                .orElse(min);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
