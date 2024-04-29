package faang.school.godbless.sprint2.stream.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUtilOperations {

    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        Utility.checkListNotNull(numbers);
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        Utility.checkListNotNull(numbers);
        return numbers.stream()
                .max(Integer::compare);
    }

    public static double findAverage(List<Integer> numbers) {
        Utility.checkListNotNull(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public static long countStringsStartingWithChar(List<String> strings, char symbol) {
        Utility.checkListNotNull(strings);
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringContainingSubstring(List<String> strings, String substring) {
        Utility.checkListNotNull(strings);
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        Utility.checkListNotNull(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean areAllNumbersGreaterThanValue(List<Integer> numbers, int minValue) {
        Utility.checkListNotNull(numbers);
        return numbers.stream()
                .allMatch(number -> number > minValue);
    }

    public static Optional<Integer> findSmallestGreaterThanValue(List<Integer> numbers, int minValue) {
        Utility.checkListNotNull(numbers);
        return numbers.stream()
                .filter(number -> number > minValue)
                .min(Integer::compare);
    }

    public static List<Integer> convertStringsToTheirLengths(List<String> strings) {
        Utility.checkListNotNull(strings);
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
