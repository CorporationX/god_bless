package school.faang.stream1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StreamTest {
    public static int sumEvenNumber(@NonNull List<Integer> numbers) {
        isEmptyList(numbers);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        return sum;
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        isEmptyList(numbers);
        Optional<Integer> maxElement = numbers.stream()
                .reduce(Integer::max);
        return maxElement.orElse(0);
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        isEmptyList(numbers);
        double everage = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        return everage;
    }

    public static long countStringsStartingWith(@NonNull List<String> str, char character) {
        isEmptyList(str);
        long counterStr = str.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .count();
        return counterStr;
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> str,
                                                                @NonNull String substring) {
        isEmptyList(str);
        List<String> filteredStr = str.stream()
                .filter(s -> s.contains(substring))
                .toList();
        return filteredStr;
    }

    public static List<String> sortByLength(@NonNull List<String> str) {
        isEmptyList(str);
        List<String> filteredStr = str.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        return filteredStr;
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers,
                                            Predicate<Integer> condition) {
        isEmptyList(numbers);
        boolean isCondition = numbers.stream()
                .allMatch(condition);
        return isCondition;
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        isEmptyList(numbers);
        int result = numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compare)
                .orElse(0);
        return result;
    }

    public static List<Integer> convertToLengths(@NonNull List<String> str) {
        isEmptyList(str);
        List<Integer> result = str.stream()
                .map(String::length)
                .toList();
        return result;
    }

    private static <T> void isEmptyList(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("list is empty");
        }

    }
}
