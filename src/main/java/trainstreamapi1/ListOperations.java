package trainstreamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .get();
    }

    public static double findAvgNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsContaining(List<String> strings, String subString) {
        return strings.stream()
                .filter(s -> s.contains(subString))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allElementsMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findSmallestElementGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(n -> n > target)
                .findFirst()
                .get();
    }

    public static List<Integer> mapStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
