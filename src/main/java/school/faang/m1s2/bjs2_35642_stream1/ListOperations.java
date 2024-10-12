package school.faang.m1s2.bjs2_35642_stream1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new NoSuchElementException("The list is empty"));

    }

    public static long countStringsStartingWith(List<String> list, char letter) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int target) {
        return list.stream()
                .filter(i -> i > target)
                .min(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("All numbers are lower than" + target));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }


}
