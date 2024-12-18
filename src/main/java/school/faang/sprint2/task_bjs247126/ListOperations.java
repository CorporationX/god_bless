package school.faang.sprint2.task_bjs247126;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(k -> k % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max()
                .orElseThrow(() -> new IllegalArgumentException("Нет подходящих чисел."));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::doubleValue).average()
                .orElseThrow(() -> new IllegalArgumentException("Нет подходящих чисел."));
    }

    public static int countStringsStartingWith(List<String> words, char firstSymbol) {
        return (int) words.stream().filter(word -> word.charAt(0) == firstSymbol).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String substring) {
        return words.stream().filter(w -> w.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int givenNumber) {
        return numbers.stream().filter(n -> n > givenNumber).mapToInt(Integer::intValue).min()
                .orElseThrow(() -> new IllegalArgumentException("Нет подходящих чисел."));
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
