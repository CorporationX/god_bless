package school.faang.bjs2_80710_stream_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (sum, number) ->
                number % 2 == 0 ? sum + number : sum
        );
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(a -> a));
    }

    public static Optional<Double> findAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Optional.empty();
        }

        int total = numbers.stream().reduce(0, Integer::sum);
        return Optional.of((double) total / numbers.size());
    }

    public static Integer countStringsStartingWith(List<String> strings, char start) {
        if (strings == null) {
            return 0;
        }

        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(start)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String needle) {
        if (strings == null || needle == null) {
            return new ArrayList<>();
        }

        return strings.stream()
                .filter(s -> s.contains(needle)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        if (numbers == null) {
            return false;
        }

        return numbers.stream().allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, int baseline) {
        if (numbers == null) {
            return Optional.empty();
        }

        return numbers.stream().filter(num -> num > baseline).min(Integer::compare);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream().map(String::length).toList();
    }

}
