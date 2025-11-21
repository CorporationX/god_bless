package school.faang.bjs2_88099;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().mapToInt(n -> n).max().orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToDouble(n -> n).average().orElse(0d);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream().filter(s -> s.charAt(0) == ch).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream().filter(s -> s.contains(str)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int barrier) {
        return numbers.stream().filter(n -> n > barrier).mapToInt(n -> n).min().orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(s -> s.length()).toList();
    }
}
