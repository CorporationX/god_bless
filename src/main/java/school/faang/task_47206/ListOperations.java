package school.faang.task_47206;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).filter(n -> n % 2 == 0).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElseGet(() -> 0);
    }

    public static int countStringStartingWith(List<String> list, String str) {
        return (int) list.stream().filter(s -> s.startsWith(str)).count();
    }

    public static List<String> filterStringContainingSubstring(List<String> list, String str) {
        return list.stream().filter(s -> s.contains(str)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int min) {
        return list.stream().mapToInt(Integer::intValue).filter(s -> s > min).min().getAsInt();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
