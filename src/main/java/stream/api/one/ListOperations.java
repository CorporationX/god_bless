package stream.api.one;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEven(List<Integer> nums) {
        if (Objects.isNull(nums)) {
            new IllegalArgumentException("Null parameter!");
        }
        return nums
                .stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static double findMaxElement(List<Integer> nums) {
        if (Objects.isNull(nums)) {
            new IllegalArgumentException("Null parameter!");
        }

        Optional<Integer> optionalMax = nums
                .stream()
                .max(Integer::compareTo);

        if (optionalMax.isPresent()) {
            return (double) optionalMax.get();
        }
        return -1;
    }

    public static double calculateAvg(List<Integer> nums) {
        if (Objects.isNull(nums)) {
            new IllegalArgumentException("Null parameter!");
        }
        return (double) nums.stream()
                .reduce(0, Integer::sum) / nums.size();
    }

    public static long countStringsStartWithSymbol(List<String> strings, char symbol) {
        if (Objects.isNull(strings) || Objects.isNull(symbol)) {
            new IllegalArgumentException("Null parameter!");
        }
        return strings
                .stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterByContainingSubstring(List<String> strings, String sub) {
        if (Objects.isNull(strings) || Objects.isNull(sub)) {
            new IllegalArgumentException("Null parameter!");
        }
        return strings.stream()
                .filter(str -> str.contains(sub))
                .toList();
    }

    public static List<String> sortStringsByLenght(List<String> strings) {
        if (Objects.isNull(strings)) {
            new IllegalArgumentException("Null parameter!");
        }
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkIfAllMatch(List<Integer> nums, Predicate<Integer> predicate) {
        if (Objects.isNull(nums) || Objects.isNull(predicate)) {
            new IllegalArgumentException("Null parameter!");
        }
        return nums
                .stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> nums, int target) {
        if (Objects.isNull(nums)) {
            new IllegalArgumentException("Null parameter!");
        }
        Optional<Integer> optionalMin = nums
                .stream()
                .filter(num -> num > target)
                .min(Integer::compareTo);

        if (optionalMin.isPresent()) {
            return optionalMin.get();
        }
        return -1;
    }

    public static List<Integer> getStringsLenghtList(List<String> strings) {
        if (Objects.isNull(strings)) {
            new IllegalArgumentException("Null parameter!");
        }
        return strings.stream().map(String::length).toList();
    }
}
