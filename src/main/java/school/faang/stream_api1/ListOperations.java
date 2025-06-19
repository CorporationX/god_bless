package school.faang.stream_api1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> nums) {
        Optional<Integer> result = nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum);

        return result.orElse(0);
    }

    public static int sumOfEvenNumbersAlternative(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings,
                                                                @NonNull String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> nums, @NonNull Predicate<Integer> filter) {
        return nums.stream()
                .allMatch(num -> filter.test(num));
    }

    public static int findMinGreaterThan(@NonNull List<Integer> nums, int min) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num > min)
                .min()
                .orElseThrow(() -> new NoSuchElementException("not found"));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
