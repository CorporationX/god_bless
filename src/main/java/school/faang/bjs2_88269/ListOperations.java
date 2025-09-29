package school.faang.bjs2_88269;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(Objects::nonNull)
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(n -> n)
                .max()
                .orElseThrow();
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(n -> n)
                .average()
                .orElseThrow();
    }

    public static long countStringsStartingWith(List<String> lines, char symbol) {
        return lines.stream()
                .filter(Objects::nonNull)
                .filter(n -> !n.isEmpty())
                .filter(n -> Character.toLowerCase(n.charAt(0)) == Character.toLowerCase(symbol))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> lines, String substring) {
        return lines.stream()
                .filter(Objects::nonNull)
                .filter(n -> n.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> lines, Predicate<Integer> predicate) {
        return lines.stream()
                .filter(Objects::nonNull)
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> lines, int nums) {
        return lines.stream()
                .filter(Objects::nonNull)
                .filter(n -> n > nums)
                .min(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
