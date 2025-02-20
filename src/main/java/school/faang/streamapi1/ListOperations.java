package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Максимумальное значение не найдено"));
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countStringsStartingWith(List<String> words, char symbol) {
        String prefix = String.valueOf(symbol);
        return words.stream()
                .filter(word -> word.startsWith(prefix))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(num -> num > minValue)
                .sorted()
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
