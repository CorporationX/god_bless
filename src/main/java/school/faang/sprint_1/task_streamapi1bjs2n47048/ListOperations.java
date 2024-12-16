package school.faang.sprint_1.task_streamapi1bjs2n47048;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listInteger) {
        return listInteger.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> listInteger) {
        return listInteger.stream()
                .max(Integer::compare).orElseThrow(
                        () -> {
                            log.info("null value in findMax method");
                            return new NullPointerException("Value by orElseThrow() in findMax method");
                        });
    }

    public static double findAverage(List<Integer> listInteger) {
        int sum = listInteger.stream()
                .mapToInt(Integer::intValue).sum();
        return (double) sum / listInteger.size();
    }

    public static int countStringsStartingWith(List<String> listInteger, char ch) {
        return (int) listInteger.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> listInteger, String startString) {
        return listInteger.stream()
                .filter(s -> s.contains(startString))
                .toList();
    }

    public static List<String> sortByLength(List<String> listInteger) {
        return listInteger.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.size() == numbers.stream()
                .filter(condition)
                .toList()
                .size();
    }

    public static int findMinGreaterThan(List<Integer> numbers, int refValue) {
        return numbers.stream()
                .filter(n -> n > refValue)
                .mapToInt(x -> x).min().orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
