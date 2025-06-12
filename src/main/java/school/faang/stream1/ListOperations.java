package school.faang.stream1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Danil Pudovkin
 * @since 12.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> integers) {
        return integers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double findAverage(List<Integer> integers) {
        return (double) integers.stream().reduce(0, Integer::sum) / integers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> s.charAt(0) == prefix)
                .count();
    }

    public static long filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .count();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted()
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integers, int max) {
        return integers.stream()
                .filter(i -> i > max)
                .min(Integer::compare)
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
