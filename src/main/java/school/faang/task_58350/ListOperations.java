package school.faang.task_58350;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class ListOperations {
    private static final int DEFAULT_NUMBER = 0;

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(ListOperations::isEvenNumber)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(DEFAULT_NUMBER);
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        }
        return DEFAULT_NUMBER;
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(string -> isStartWithChar(string, startSymbol))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(
            @NonNull List<String> strings, @NonNull String substring
    ) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int threshold) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(number -> number > threshold)
                .min()
                .orElse(DEFAULT_NUMBER);
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static boolean isStartWithChar(@NonNull String string, char symbol) {
        return string.startsWith(String.valueOf(symbol));
    }
}
