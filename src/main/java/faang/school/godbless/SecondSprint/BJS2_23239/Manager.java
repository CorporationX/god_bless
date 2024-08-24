package faang.school.godbless.SecondSprint.BJS2_23239;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Manager {
    public static int sumOfEven(List<Integer> input) {
        int result = input.stream().filter(n -> n % 2 == 0).mapToInt(item -> item).sum();

        return result;
    }

    public static int findMax(List<Integer> input) {
        int result = input.stream().max(Comparator.naturalOrder()).orElseThrow();

        return result;
    }

    public static double average(List<Integer> input) {
        double result = input.stream().mapToInt(k -> k).average().orElseThrow();

        return result;
    }

    public static long countOfStringStartWith(List<String> input, char ch) {
        long result = input.stream().filter(s -> s.startsWith(String.valueOf(ch))).count();

        return result;
    }

    public static List<String> filterBySubstring(List<String> input, String subString) {
        List<String> result = input.stream().filter(s -> s.contains(subString)).toList();

        return result;
    }

    public static List<String> sortByLength(List<String> input) {
        List<String> result = input.stream().sorted((a, k) -> a.length() - k.length()).toList();

        return result;
    }

    public static <T> boolean isMeetCondition(List<T> input, Predicate<T> predictor) {
        boolean result = input.stream().allMatch(predictor);

        return result;
    }

    public static int minFromGiven(List<Integer> input, int num) {
        int result = input.stream().filter(n -> n > num).min(Comparator.naturalOrder()).orElseThrow();

        return result;
    }

    public static List<Integer> getLenghtOfStrings(List<String> input) {
        List<Integer> result = input.stream().map((s) -> s.length()).toList();

        return result;
    }
}
