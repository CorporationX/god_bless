package school.faang.bjs2_58308;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listNumbers) {
        return listNumbers
                .stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> listNumbers) {
        return listNumbers
                .stream()
                .max(Integer::compare)
                .orElseThrow();
    }

    public static double findAverage(List<Integer> listNumbers) {
        return listNumbers
                .stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> listStrings, char start) {
        return listStrings
                .stream()
                .filter(i -> i.startsWith(String.valueOf(start)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> listStrings, String turning) {
        return listStrings
                .stream()
                .filter(i -> i.contains(turning))
                .toList();
    }

    public static List<String> sortByLength(List<String> listString) {
        return listString
                .stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> listNumbers, Predicate<Integer> condition) {
        return listNumbers
                .stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> listNumbers, int threshold) {
        return listNumbers
                .stream()
                .filter(i -> i > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException(String.format("Нет элементов больше,чем %d", threshold)));
    }

    public static List<Integer> convertToLengths(List<String> listString) {
        return listString
                .stream()
                .map(String::length)
                .toList();
    }
}
