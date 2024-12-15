package school.faang.task_47017;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamUtils {

    public static int sumEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List doesn't have Max number"));
    }

    public static double findAvg(List<Integer> numbers) {
        return numbers.isEmpty() ? 0.0 : (double) numbers.stream()
                .reduce(0, Integer::sum) / numbers.size();
    }

    public static int findStartsWith(List<String> words, char letter) {
        return (int) words.stream()
                .filter(word -> word.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> findContainsString(List<String> words, String string) {
        return words.stream()
                .filter(word -> word.contains(string))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted((Comparator.comparingInt(String::length)))
                .toList();
    }

    public static boolean isAllSatisfyPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findNextSortedNumber(List<Integer> numbers, int value) {
        return numbers.stream()
                .sorted()
                .filter(number -> number > value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("List doesn't contain any number more than " + value));
    }

    public static List<Integer> mapStringToInteger(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }

}
