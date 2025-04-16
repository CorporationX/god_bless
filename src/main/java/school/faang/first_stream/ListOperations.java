package school.faang.first_stream;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> words, char targetChar) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(targetChar)))
                .count();
    }

    public static long filterStringsContainingSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .count();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, Integer graterThan) {
        return numbers.stream()
                .filter(number -> number > graterThan)
                .min(Integer::compareTo)
                .orElse(graterThan);
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}