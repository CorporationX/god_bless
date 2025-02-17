package school.faang.BJS2_58264;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .reduce(numbers.get(0), Integer::max);
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(num -> num)
                .average().orElse(0);
    }

    public static long countStrStartingWith(@NonNull List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> str != null && !str.isBlank() && str.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStrContainingSubstr(@NonNull List<String> strings,
                                                         @NonNull String pattern) {
        return strings.stream()
                .filter(str -> str.contains(pattern))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers,
                                            @NonNull Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int border) {
        return numbers.stream()
                .filter(num -> num > border)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Элемент не найден"));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
