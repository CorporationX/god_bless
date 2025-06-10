package school.faang.bjs2_80710_stream_1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (sum, number) ->
                        number % 2 == 0 ? sum + number : sum
                );
    }

    public static Optional<Integer> findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(a -> a));
    }

    public static OptionalDouble findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .average();
    }

    public static Integer countStringsStartingWith(@NonNull List<String> strings, char start) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(start)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, @NonNull String needle) {
        return strings.stream()
                .filter(s -> s.contains(needle))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(@NonNull List<Integer> numbers, int baseline) {
        return numbers.stream()
                .filter(num -> num > baseline)
                .min(Integer::compare);
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
