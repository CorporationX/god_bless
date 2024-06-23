package faang.school.godbless.streams.task_1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util {

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int maxOfNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double avgOfNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    public static long countStringsStartingWith(
            @NonNull List<String> strings,
            char startingCharacter
    ) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(startingCharacter)))
                .count();
    }

    public static List<String> filterStringContainingSubstring(
            @NonNull List<String> strings,
            @NonNull String substring
    ) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkIfAllMatchCondition(
            @NonNull List<T> list,
            @NonNull Predicate<T> predicate
    ) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(
            @NonNull List<Integer> numbers,
            int threshold
    ) {
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Integer::compare)
                .orElse(0);
    }

    public static List<Integer> mapToLengthsOfStrings(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
