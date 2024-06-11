package BJS2_10360;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> strings = Arrays.asList("water", "food", "bed", "date");

        System.out.println("Sum: " + sum(nums));
        System.out.println("Max number: " + max(nums));
        System.out.println("Average: " + average(nums));
        System.out.println("Count of strings starting with 'f': " + countStringsStartWith(strings, 'f'));
        System.out.println("Strings containing 'be': " + filterStringsContaining(strings, "be"));
        System.out.println("Strings sorted by length: " + sortedStrings(strings));
        System.out.println("All numbers greater than 2: " + checkCondition(nums, n -> n > 2));
        System.out.println("Min number greater than 3: " + minAmongMax(nums, 3));
        System.out.println("Lengths of strings: " + mapToLength(strings));
    }

    public static int sum(List<Integer> nums) {
        if (nums == null || nums.isEmpty() || nums.contains(null))
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        if (nums == null || nums.isEmpty())
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        return nums.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double average(List<Integer> nums) {
        if (nums == null || nums.isEmpty())
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        return nums.stream()
                .mapToInt(Integer::intValue).average()
                .orElse(0.0);
    }

    public static long countStringsStartWith(List<String> words, char symbol) {
        if (words == null || words.isEmpty() || Character.isWhitespace(symbol))
            throw new IllegalArgumentException("List of strings must not be null or empty.");
        return words.stream()
                .filter(word ->  word.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringsContaining(List<String> words, String substring) {
        if (words == null || words.isEmpty() || substring.trim().isEmpty() || substring == null)
            throw new IllegalArgumentException("List of strings must not be null or empty.");
        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortedStrings(List<String> words) {
        if (words == null || words.isEmpty())
            throw new IllegalArgumentException("List of strings must not be null or empty.");
        return words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static <T> boolean checkCondition(List<T> data, Predicate<T> condition) {
        if (data == null || data.isEmpty())
            throw new IllegalArgumentException("List of data must not be null or empty.");
        return data.stream().allMatch(condition);
    }

    public static int minAmongMax(List<Integer> nums, int number) {
        if (nums == null || nums.isEmpty())
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        return nums.stream()
                .distinct()
                .filter(num -> num > number)
                .min(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("Not found value"));
    }

    public static List<Integer> mapToLength(List<String> words) {
        if (words == null || words.isEmpty())
            throw new IllegalArgumentException("List of strings must not be null or empty.");
        return words.stream().map(String::length).toList();
    }
}
