package school.faang.streamApi.training_one;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxNumber(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Empty List"));
    }

    public static double findMean(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStatingWith(List<String> list, char firstSymbol) {
        return list.stream()
                .filter(word -> !word.isEmpty() && word.charAt(0) == firstSymbol)
                .count();
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkCondition(List<Integer> list, Predicate<Integer> condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static int findMinNumberComparedTo(List<Integer> list, int compared) {
        return list.stream()
                .filter(integer -> integer > compared)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Absence of numbers larger then %d".formatted(compared)));
    }

    public static List<Integer> toStringLengthList(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
