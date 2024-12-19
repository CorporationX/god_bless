package school.faang.sprint2.task8;

import lombok.NonNull;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@NonNull
public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        return intStream.filter(n -> n % 2 == 0).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow(() -> new IllegalArgumentException("Error happened"));
    }

    public static double findAverage(List<Integer> numbers) {
        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
        return intStream.average().orElseThrow(() -> new IllegalArgumentException("Error happened"));
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream().filter(s -> s.charAt(0) == c).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int n) {
        return numbers.stream().filter(i -> i > n).min(Integer::compare).orElseThrow(() -> new IllegalArgumentException("Error happened"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
