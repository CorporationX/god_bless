package school.faang.sprint2.task_47211;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (Integer::sum));
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> words, char firstChar) {
        return (int) words.stream()
                .filter((word) -> word.startsWith(String.valueOf(firstChar)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String subString) {
        return words.stream()
                .filter(word -> word.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted((word1, word2) -> word1.length() - word2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> num > target)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Не нашлось подходящего элемента"));
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
