package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.charAt(0) == c)
                .count();
    }

    public static  List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n > num)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No such element"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
