package school.faang.bjs2_70739;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double countAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static long countStringsStartWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> stringContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkListOfIntegers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findFirstBiggerThanCondition(List<Integer> numbers, int condition) {
        return numbers.stream()
                .sorted()
                .filter(num -> num > condition)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("List don't contains number bigger than %s".formatted(condition)));
    }

    public static List<Integer> mapStringsIntoLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}