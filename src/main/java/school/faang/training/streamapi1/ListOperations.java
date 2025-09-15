package school.faang.training.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);

    }

    static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .sum() / numbers.size();
    }

    static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .count();
    }

    static List<String> filterStringsContainingSubstring(List<String> strings, String ch) {
        return strings.stream()
                .filter(string -> string.contains(ch))
                .toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    static boolean allMatchCondition(List<Integer> strings, Predicate<Integer> filter) {
        return strings.stream().allMatch(filter);
    }

    static int findMinGreaterThan(List<Integer> numbers, int condition) {
        return numbers.stream()
                .filter(number -> number > condition)
                .min(Integer::compareTo)
                .orElse(0);
    }

    static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
