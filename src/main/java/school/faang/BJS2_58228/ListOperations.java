package school.faang.BJS2_58228;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(("List is empty")));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException(("List is empty")));
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        checkNull(strings);

        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        if (strings == null || subString == null) {
            throw new IllegalArgumentException(
                    String.format("Input list or subString cannot be null %n" +
                            "Input list:%s subString%s ", strings, subString)
            );
        }

        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        checkNull(strings);

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        if (numbers == null || filter == null) {
            throw new IllegalArgumentException(
                    String.format("Input list or filter cannot be null %n" +
                            "Input list:%s filter%s ", numbers, filter)
            );
        }

        return numbers.stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int min) {
        checkNull(numbers);

        return numbers.stream()
                .filter(number -> number > min)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No number greater than " + min + " found"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkNull(strings);

        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static <T> void checkNull(T param) {
        if (param == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
    }
}