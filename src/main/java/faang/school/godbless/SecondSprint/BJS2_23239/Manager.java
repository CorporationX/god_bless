package faang.school.godbless.SecondSprint.BJS2_23239;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Manager {
    public static int sumOfEven(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(item -> item)
                .sum();
    }

    public static int findMax(List<Integer> input) {
        return input.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static double average(List<Integer> input) {
        return input.stream()
                .mapToInt(k -> k)
                .average()
                .orElseThrow();
    }

    public static long countOfStringStartWith(List<String> input, char ch) {
        return input.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterBySubstring(List<String> input, String subString) {
        return input.stream()
                .filter(s -> s.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> input) {
        return input.stream()
                .sorted((a, k) -> a.length() - k.length())
                .toList();
    }

    public static <T> boolean isMeetCondition(List<T> input, Predicate<T> predictor) {
        return input.stream()
                .allMatch(predictor);
    }

    public static int minFromGiven(List<Integer> input, int num) {
        return input.stream()
                .filter(n -> n > num)
                .min(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static List<Integer> getLenghtOfStrings(List<String> input) {
        return input.stream()
                .map((s) -> s.length())
                .toList();
    }
}
