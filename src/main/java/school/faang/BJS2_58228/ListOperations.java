package school.faang.BJS2_58228;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(ListOperations::isEven)
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
        checkNull(strings, "List<String>");

        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        checkNull(strings, "List<String>");
        checkNull(subString, "String subString");

        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        checkNull(strings, "List<String>");

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        checkNull(numbers, "List<Integer>");
        checkNull(filter, "Predicate<Integer>");

        return numbers.stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int min) {
        checkNull(numbers, "List<Integer>");

        return numbers.stream()
                .filter(number -> number > min)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No number greater than " + min + " found"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkNull(strings, "List<String>");

        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static <T> void checkNull(T param, String paramName) {
        if (param == null) {
            throw new IllegalArgumentException(String.format("%s cannot be null ", paramName));
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}