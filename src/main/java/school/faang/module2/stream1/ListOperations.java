package school.faang.module2.stream1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int findSumOfEvenIntElements(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public static int findMaxOfIntElements(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    public static double findAverageOfIntElements(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean getAllMatchCondition(List<Integer> ints, Predicate<Integer> predicate) {
        return ints.stream()
                .filter(predicate)
                .count() == ints.size();
    }

    public static int findMinGreaterThan(List<Integer> ints, int greater) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i > greater)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
