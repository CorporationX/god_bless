package streamApiOne;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return
                numbers.stream()
                        .map(n -> (double) n / numbers.size())
                        .reduce(Double::sum)
                        .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char a) {
        return (int) strings.stream()
                .filter(str -> str.toLowerCase().charAt(0) == a)
                .count();
    }

    public static String filterStringsContainingSubstring(List<String> strings, String an) {
        return strings.stream()
                .filter(str -> str.toLowerCase().contains(an))
                .toList()
                .toString();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(number -> number > i)
                .min(Comparator.naturalOrder())
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                        .map(String::length)
                        .toList();
    }
}
