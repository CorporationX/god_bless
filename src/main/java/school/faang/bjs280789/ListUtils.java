package school.faang.bjs280789;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtils {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get();
    }

    public static int findAverage(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        int sum = stream.reduce(0, Integer::sum);
        return sum / numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(x -> x.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(x -> x.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(x -> x > number)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
