package school.faang.bjs247027;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Utilities {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Maximum number is not present"));
    }

    public static Double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Average number is not present"));
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integers, int target) {
        return integers.stream()
                .filter(integer -> integer > target)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Minimum number is not present"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
