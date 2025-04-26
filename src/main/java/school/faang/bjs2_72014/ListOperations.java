package school.faang.bjs2_72014;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == prefix)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }


    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }


    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int comparingNum) {
        return numbers.stream()
                .filter(num -> num > comparingNum)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список чисел пуст"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
