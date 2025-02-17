package school.faang.sprint2.task_58213;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Operations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer % 2 == 0)
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
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> list, char c) {
        return list.stream()
                .filter(s -> !s.isBlank() && s.charAt(0) == c)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String string) {
        return list.stream()
                .filter(s -> !s.isBlank() && s.contains(string))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream()
                .filter(x -> x > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("There are no elements more than " + number));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
