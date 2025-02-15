package school.faang.task_56236;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty."));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char a) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(a)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subStrings) {
        return strings.stream()
                .filter(s -> s.contains(subStrings))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(n -> n > i)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(null);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
