package bjs258257;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0)
                .reduce(Integer::sum).orElse(0);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.averagingDouble(number -> number));
    }

    public static long countStringsStartingWith(List<String> strings, char startSymbol) {
        return strings.stream().filter(string -> string.startsWith(String.valueOf(startSymbol))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream().filter(string -> string.contains(subString)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing((String::length))).toList();
    }

    public static boolean allMatchCondition(List<Integer> strings, Predicate<Integer> predicate) {
        return strings.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream().filter(number -> number > value).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> numbers) {
        return numbers.stream().map(String::length).toList();
    }
}
