package school.faang.bjs246939;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> nums) {
        validate(nums);
        return nums.stream()
                .filter(num -> (num % 2) == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> nums) {
        validate(nums);
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Error"));
    }

    public static double findAverage(List<Integer> nums) {
        validate(nums);
        double sum = nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
        double count = nums.size();
        return sum / count;
    }

    public static int countStringsStartingWith(List<String> words, char letter) {
        validate(words);
        return (int) words.stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String text) {
        validate(words);
        return words.stream()
                .filter(word -> !word.isEmpty() && word.contains(text))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        validate(words);
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> predicate) {
        validate(nums);
        return nums.stream()
                .anyMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> nums, int target) {
        validate(nums);
        return nums.stream()
                .filter(n -> n > target)
                .min(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(() -> new IllegalArgumentException("Error !"));
    }

    public static List<Integer> convertToLengths(List<String> words) {
        validate(words);
        return words.stream()
                .map(String::length)
                .toList();
    }

    private static void validate(List<?> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Argument must be not null or empty");
        }
    }
}
