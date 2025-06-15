package school.faang.streamAPI80831;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max((n1, n2) -> n1 - n2).orElseThrow(() -> new RuntimeException("Значение отсутствует"));
    }

    public static double findAverage(List<Integer> list) {
        return (double) list.stream().mapToInt(Integer::intValue).sum() / list.size();
    }

    public static long countStringsStartingWith(List<String> list, char c) {
        return list.stream().filter(i -> i.charAt(0) == c).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String str) {
        return list.stream().filter(i -> i.contains(str)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).toList().size() == list.size();
    }

    public static int findMinGreaterThan(List<Integer> list, int n) {
        return list.stream().filter(i -> i > n).min((n1, n2) -> n1 - n2).orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
