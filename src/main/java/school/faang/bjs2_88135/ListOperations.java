package school.faang.bjs2_88135;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .reduce(0, (x, y) -> Math.max(x, y));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i.intValue())
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> list, char prefix) {
        return list.stream()
                .filter(x -> x.startsWith(String.valueOf(prefix)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String word) {
        return list.stream()
                .filter(x -> x.contains(word))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted((x, y) -> Integer.compare(x.length(), y.length()))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> filter) {
        return list.stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> list, int decimal) {
        return list.stream()
                .filter(x -> x > decimal)
                .min(Comparator.naturalOrder())
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(x -> x.length())
                .toList();
    }
}
