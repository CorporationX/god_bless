package school.faang.bjs2_80797;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().flatMapToInt(IntStream::of).average().orElseThrow();
    }

    public static long countStringsStartingWith(List<String> strings, char startingChar) {
        return strings.stream().filter(str -> str.charAt(0) == startingChar).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(str -> str.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int lowerLimit) {
        return numbers.stream().filter(num -> num > lowerLimit).min(Integer::compare).orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

}
