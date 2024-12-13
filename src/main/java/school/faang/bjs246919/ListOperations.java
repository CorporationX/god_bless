package school.faang.bjs246919;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static String sumOfEvenNumbers(List<Integer> numbers) {
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
        return Integer.toString(result);
    }

    public static String findMax(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .max(Comparator.naturalOrder());
        return result.map(Objects::toString).orElse("No max number found");
    }

    public static String findAverage(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return average.isPresent() ? Double.toString(average.getAsDouble()) : "No average found";
    }

    public static String countStringsStartingWith(List<String> strings, char chr) {
        return Long.toString(strings.stream()
                .filter(string -> string.charAt(0) == chr)
                .count());
    }

    public static String filterStringsContainingSubstring(List<String> strings, String string) {
        return String.join(", ",
                strings.stream()
                        .filter(str -> str.contains(string))
                        .toList());
    }

    public static String sortByLength(List<String> strings) {
        return strings.stream()
                        .sorted(Comparator.comparingInt(String::length))
                        .collect(Collectors.joining(", "));
    }

    public static String allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                        .filter(predicate)
                        .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    public static String findMinGreaterThan(List<Integer> numbers, int minimal) {
        return numbers.stream()
                .filter(number -> number > minimal)
                .min(Comparator.naturalOrder())
                .toString();
    }

    public static String convertToLengths(List<String> strings) {
        return strings.stream()
                        .map(String::length)
                        .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
