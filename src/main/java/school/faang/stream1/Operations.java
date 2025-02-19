package school.faang.stream1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Operations {
    public static int findTheSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findTheMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty."));
    }

    public static double findTheAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long findTheNumber(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterTheList(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortTheList(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean verifyCompliance(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findTheSmallestElement(List<Integer> numbers, int limit) {
        return numbers.stream()
                .filter(x -> x > limit)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("There are no elements more than: " + limit));
    }

    public static List<Integer> convertList(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
