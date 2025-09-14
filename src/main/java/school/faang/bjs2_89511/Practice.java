package school.faang.bjs2_89511;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice {

    public static Optional<Integer> findMax(List<Integer> values) {
        return values.stream()
                .max(Comparator.naturalOrder());
    }

    public static int sumEvenNumbers(List<Integer> values) {
        return values.stream()
                .filter(val -> val % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static OptionalDouble averageValue(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long countStringsStartsWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.charAt(0) == symbol)
                .count();
    }

    public static List<String> stringsContainsSubstring(List<String> list, String string) {
        return list.stream()
                .filter(s -> s.contains(string))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allNumsMatchFilter(List<Integer> elements, Predicate<Integer> filterEl) {
        return elements.stream()
                .allMatch(filterEl);
    }

    public static int findMin(List<Integer> list, int value) {
        return list.stream()
                .filter(v -> v > value)
                .sorted()
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> getStringsLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}