package school.faang.sprint_2.task_46988;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listNumbers) {
        return listNumbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> listNumbers) {
        return listNumbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("list is empty"));
    }

    public static double findAverage(List<Integer> listNumbers) {
        return listNumbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char key) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == key)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String key) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.contains(key))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int key) {
        return numbers.stream()
                .filter(n -> n > key)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("numbers bigger " + key + " not found"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}