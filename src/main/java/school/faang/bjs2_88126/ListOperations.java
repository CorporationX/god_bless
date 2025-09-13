package school.faang.bjs2_88126;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (x, y) -> x + y);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (x, y) -> Math.max(x, y));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(integer -> integer.intValue())
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Comparator.naturalOrder())
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }
}