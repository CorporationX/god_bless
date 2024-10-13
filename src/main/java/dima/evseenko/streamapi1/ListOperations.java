package dima.evseenko.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).mapToInt(num -> num).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compare).orElseThrow(NullPointerException::new);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(num -> num).average().orElseThrow(NullPointerException::new);
    }

    public static int countStringsStartingWith(List<String> list, char chr) {
        return (int) list.stream().filter(s -> s.startsWith(String.valueOf(chr))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substr) {
        return list.stream().filter(s -> s.contains(substr)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int min) {
        return list.stream().filter(num -> num >= min).min(Integer::compare).orElseThrow(NullPointerException::new);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
