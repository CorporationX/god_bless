package school.faang.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int findSumOfEventNumber(List<Integer> numbers) {
        return numbers.stream().
                filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().
                max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().
                mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> wordList, char letter) {
        return (int) wordList.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> conditions) {
        return numbers.stream().allMatch(conditions);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int limit) {
        return numbers.stream()
                .filter(x -> x > limit)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No number less than " + limit));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
