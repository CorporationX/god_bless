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

    public static String findMax(List<Integer> numbers) {
        return String.valueOf(
                numbers.stream()
                        .max(Comparator.naturalOrder())
        );
    }

    public static String findAverage(List<Integer> numbers) {
        return String.valueOf(
                numbers.stream()
                        .map(n -> (double) n / numbers.size())
                        .reduce(Double::sum)

        );
    }

    public static String countStringsStartingWith(List<String> strings, char a) {
        return String.valueOf(
                strings.stream()
                        .filter(str -> str.toLowerCase().charAt(0) == a)
                        .count()
        );
    }

    public static String filterStringsContainingSubstring(List<String> strings, String an) {
        return String.valueOf(
                strings.stream()
                        .filter(str -> str.toLowerCase().contains(an))
                        .count()
        );
    }

    public static String sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList()
                .toString();
    }

    public static String allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return String.valueOf(numbers.stream()
                .allMatch(predicate)
        );
    }

    public static String findMinGreaterThan(List<Integer> numbers, int i) {
        return String.valueOf(
                numbers.stream()
                        .filter(number -> number > i)
                        .min(Comparator.naturalOrder())
        );
    }

    public static String convertToLengths(List<String> strings) {
        return String.valueOf(
                strings.stream()
                        .map(String::length)
                        .toList()
        );
    }
}
