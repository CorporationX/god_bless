package school.faang.trainingstreamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> list, char symbol) {
        return (int) list.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        return list.stream()
                .filter(string -> string.contains(substring))
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

    public static int findMinGreaterThan(List<Integer> list, int border) {
        return list.stream()
                .filter(number -> number > border)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
