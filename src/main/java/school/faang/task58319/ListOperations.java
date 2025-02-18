package school.faang.task58319;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .max()
                .orElseThrow(() -> new NoSuchElementException("List пуст."));
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List пуст."));
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char a) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(a)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, @NonNull String an) {
        return strings.stream()
                .filter(s -> s.contains(an))
                .collect(Collectors.toList());
    }


    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }


    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(n -> n > i)
                .mapToInt(n -> n)
                .min()
                .orElseThrow(() -> new NoSuchElementException("List пуст."));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
