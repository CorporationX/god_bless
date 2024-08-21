package faang.school.godbless.StreamAPI1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        System.out.println("Even numbers' sum: " + getEvenNumbers(numbers));
        System.out.println("Max number: " + findMax(numbers));
        System.out.println("Average value: " + findAverage(numbers));
        System.out.println("Number of strings starting with 'a': " + countStringsStartingWith(strings, 'a'));
        System.out.println("Strings with 'a': " + filterStringsWith(strings, "a"));
        System.out.println("Strings sorted by length: " + sortByLength(strings));
        System.out.println("All numbers are greater than 5? " + allMatchCondition(numbers, 5));
        System.out.println("Min number greater than 7: " + findMinGreaterThan(numbers, 7));
        System.out.println("Strings' length: " + mapToLengths(strings));
    }

    public static int getEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Optional<Integer> findMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo);
    }

    public static OptionalDouble findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
    }

    public static int countStringsStartingWith(List<String> strings, char letter) {
        return (int) strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsWith(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .allMatch(n -> n > threshold);
    }

    public static OptionalInt findMinGreaterThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(n -> n > minValue)
                .mapToInt(Integer::intValue)
                .min();
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
