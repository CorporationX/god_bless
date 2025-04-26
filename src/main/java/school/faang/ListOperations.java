package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {


    public static int sumOfEvenNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream().filter(s -> s.charAt(0) == c).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        List<String> filtered = new ArrayList<>();
        for (String s : strings) {
            if (s.contains(substring)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public static List<String> sortByLength(List<String> strings) {
        strings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return strings;
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("Нет элементов больше заданного числа"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        List<Integer> lengths = new ArrayList<>();
        for (String s : strings) {
            lengths.add(s.length());
        }
        return lengths;
    }
}