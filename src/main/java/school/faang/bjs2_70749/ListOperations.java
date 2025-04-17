package school.faang.bjs2_70749;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .filter(value -> Objects.equals(value % 2, 0))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(ValueNotFoundException::new);
    }

    public static double getAverage(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(ValueNotFoundException::new);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        String prefix = String.valueOf(ch).toLowerCase();
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.isBlank())
                .map(String::trim)
                .filter(str -> str.toLowerCase().startsWith(prefix))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.nullsLast(Comparator.comparingInt(String::length)))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> condition) {
        return integers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> integers, int minValue) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .filter(value -> value > minValue)
                .min()
                .orElseThrow(ValueNotFoundException::new);
    }

    public static List<Integer> toLengths(List<String> strings) {
        return strings.stream()
                .map(str -> Objects.isNull(str) ? 0 : str.length())
                .toList();
    }
}
