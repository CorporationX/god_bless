package school.faang.bjs2_35687;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> (integer % 2 == 0))
                .reduce(0, Integer::sum);
    }

    public static int findMaxElement(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("list is empty"));
    }

    public static double findAverageOfNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("list is empty"));
    }

    public static int countStringsStartingWith(@NonNull List<String> strings, char startSymbol) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startSymbol)))
                .count();
    }

    public static List<String> filterStringsContaining(@NonNull List<String> strings, @NonNull String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(integer -> integer > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("list is empty"));

    }

    public static List<Integer> mapStringsToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
