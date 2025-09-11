package school.faang.stream1;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.Optional;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0)
                .mapToInt(i -> i)
                .sum();
    }

    public static Optional<Integer> findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo);
    }

    public static OptionalDouble findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average();
    }

    public static long countStringsStartingWith(List<String> list, char el) {
        return list.stream()
                .filter(s -> s.charAt(0) == el)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String subString) {
        return list.stream()
                .filter(s -> s.contains(subString))
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

    public static Optional<Integer> findMinGreaterThan(List<Integer> list, int sub) {
        return list.stream()
                .filter(i -> i > sub)
                .min(Integer::compareTo);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
