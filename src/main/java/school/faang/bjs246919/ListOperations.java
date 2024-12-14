package school.faang.bjs246919;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Max value could not be found"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new RuntimeException("Average value could not be found"));
    }

    public static long countStringsStartingWith(List<String> strings, char chr) {
        return strings.stream()
                .filter(string -> string.charAt(0) == chr)
                .count();
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

    public static int findMinGreaterThan(List<Integer> numbers, int minimal) {
        return numbers.stream()
                .filter(number -> number > minimal)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("There is not valur grater than min in the list"));
    }

    public static String convertToLengths(List<String> strings) {
        return strings.stream()
                        .map(String::length)
                        .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
