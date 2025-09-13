package school.faang.bjs2_89511;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice {

    public static int findMax(List<Integer> values) {
        return values.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public static int sumValid(List<Integer> values) {
        return values.stream().filter(val -> val % 2 == 0).reduce(0, Integer::sum);
    }

    public static double averageValue(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static long countString(List<String> strings, char symbol) {
        return strings.stream().filter(s -> s.charAt(0) == symbol).count();
    }

    public static List<String> filter(List<String> list, String string) {
        return list.stream().filter(s -> s.contains(string)).collect(Collectors.toList());
    }

    public static List<String> sort(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean test(List<Integer> elements, Predicate<Integer> filterEl) {
        return elements.stream().allMatch(filterEl);
    }

    public static int findMin(List<Integer> list, int value) {
        return list.stream().filter(v -> v > value).sorted().findFirst().orElse(0);
    }

    public static List<Integer> list(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}