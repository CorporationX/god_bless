package school.faang.stream1;

import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0)
                .mapToInt(i -> i)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElse(0);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(i -> i).average().orElse(0);
    }

    public static long countStringsStartingWith(List<String> list, char el) {
        return (long) list.stream().filter(s -> s.charAt(0) == el).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String subString) {
        return list.stream().filter(s -> s.contains(subString)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int sub) {
        return list.stream().filter(i -> i > sub).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(s -> s.length()).toList();
    }
}
