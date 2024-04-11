package faang.school.godbless.BJS25236;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == character)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allElementsSatisfyCondition(List<Integer> numbers, int condition) {
        return numbers.stream()
                .allMatch(num -> num >= condition);
    }

    public static int findSmallestGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> num > target)
                .min(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
