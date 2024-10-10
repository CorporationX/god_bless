package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StreamApiTester {
    public static int sum(List<Integer> list) {
        return list.stream()
                .filter(v -> v % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int max(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Empty list"));
    }

    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int minValueMoreThen(List<Integer> list, int value) {
        return list.stream()
                .filter(i -> i > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No Such Element"));
    }

    public static long countStr(List<String> list, char ch) {
        return list.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterBy(List<String> list, String subString) {
        return list.stream()
                .filter(s -> s.contains(subString)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatch(List<String> list, Predicate<String> condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static List<Integer> stringToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
