package school.faang.sprint.second.streamapifirst;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return (double) numbers.stream()
                .reduce(0, Integer::sum) / numbers.size();
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char letter) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .count();
    }

    @NonNull
    public static List<String> filterStringsContainingSubstring(
            @NonNull List<String> strings, @NonNull String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    @NonNull
    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, @NonNull Integer min) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .filter(number -> number > min)
                .findFirst()
                .orElseThrow();
    }

    @NonNull
    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
