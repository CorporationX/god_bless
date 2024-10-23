package school.faang.sprint_2.streamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum) * 1.0 / list.size();
    }

    public static int countStringsStartingWith(List<String> list, Character symbol) {
        return (int) list.stream().filter(e -> e.charAt(0) == symbol).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String str) {
        return list.stream().filter(e -> e.contains(str)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream().filter(e -> e > number).mapToInt(Integer::intValue).min().orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
