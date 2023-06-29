package practiceStreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Practice {
    public static int sumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static OptionalInt max(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public static OptionalDouble average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.charAt(0) == character)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> condition) {
        return  numbers.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> smallestElementGreaterThan(List<Integer> numbers, int numberForCheck) {
        return numbers.stream()
                .filter(n -> n > numberForCheck)
                .min(Integer::compareTo);
    }

    public static List<Integer> convertToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}