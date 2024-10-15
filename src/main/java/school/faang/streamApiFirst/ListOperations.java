package school.faang.streamApiFirst;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Empty list"));
    }

    public static double getAvgNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int getNumberOfLines(List<String> words, char symbol) {
        return (int) words.stream()
                .filter(word -> !word.isEmpty() && word.charAt(0) == symbol)
                .count();
    }

    public static List<String> getSortedListBySubstring(List<String> words, String phrase) {
        return words.stream()
                .filter(word -> word.contains(phrase))
                .toList();
    }

    public static boolean isSatisfiedByConditions(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static int getMinNumber(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(x -> x > number)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new NoSuchElementException("There is no any such number"));
    }

    public static List<Integer> mapStringToInteger(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();

    }
}
