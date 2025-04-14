package school.faang.first_stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (sum, number) -> {
            if (number % 2 == 0) {
                return sum + number;
            }
            return sum;
        });
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static long countStringsStartingWith(List<String> words, char targetChar) {
        return words.stream().filter(word -> word.charAt(0) == targetChar).count();
    }

    public static long filterStringsContainingSubstring(List<String> words, String substring) {
        return words.stream().filter(word -> word.contains(substring)).count();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, Integer graterThan) {
        return numbers.stream().filter(number -> number > graterThan).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}