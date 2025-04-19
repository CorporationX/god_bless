package school.faang.sprinttwo.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(i -> i)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(i -> i)
                .average()
                .orElse(0);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(w -> w.startsWith(Character.toString(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(w -> w.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> test) {
        return numbers.stream()
                .allMatch(test);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .filter(digits -> digits > number)
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}