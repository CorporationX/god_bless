package school.faang.BJS2_70730;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return list
                .stream()
                .mapToInt(Integer::valueOf)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0);
    }

    public static List<String> startsWith(List<String> words, char startSymbol) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(startSymbol)))
                .collect(Collectors.toList());
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> words, Predicate<Integer> condition) {
        return words.stream()
                .filter(condition)
                .count() == words.size();
    }

    public static int findMinGreaterThan(List<Integer> list, int targetNumber) {
        return list.stream()
                .sorted()
                .filter(number -> number > targetNumber)
                .findFirst()
                .orElse(targetNumber);
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
