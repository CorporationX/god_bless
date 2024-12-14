package school.faang.streamapi_one;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> list, char symbol) {
        return Math.toIntExact(list.stream()
                .filter(str -> str.charAt(0) == symbol)
                .count());
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String targetString) {
        return list.stream()
                .filter(s -> s.contains(targetString))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> list, int thresholdValue) {
        return list.stream()
                .filter(n -> n > thresholdValue)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No elements by condition"));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
