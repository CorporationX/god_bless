package school.faang.naughtwoBJS258366;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double averageOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static boolean allNumbersCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinNumberGreaterThan(List<Integer> numbers, int bound) {
        return numbers.stream()
                .filter(number -> number > bound)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }


    public static long countStringsStartWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && (s.charAt(0) == ch))
                .count();
    }

    public static List<String> filterContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
