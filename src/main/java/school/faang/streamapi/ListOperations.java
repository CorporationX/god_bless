package school.faang.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(x -> x)).orElseThrow(() -> new IllegalArgumentException("Empty list is provided"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::valueOf).average().orElseThrow(() -> new IllegalArgumentException("Empty list is provided"));
    }

    public static int countStringsStartingWith(List<String> strings, char startSymbol) {
        return (int) strings.stream().filter(s -> s.startsWith(String.valueOf(startSymbol))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String filter) {
        return strings.stream().filter(s -> s.contains(filter)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int bottomLimit) {
        return numbers.stream().mapToInt(Integer::valueOf).filter(i-> i> bottomLimit).min().orElseThrow(IllegalArgumentException::new);
    }

    public static List<Integer> convertToLengths(List<String> numbers) {
        return numbers.stream().map(String::length).toList();
    }
}
