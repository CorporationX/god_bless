package school.faang.godbless.bjs2_35493;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class UtilsWithStreamApi {
    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int getMaxNumber(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public static int getAverage(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("can not find average of an empty list");
        }
        return numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    public static int countStartsWith(List<String> words, char symbol) {
        Objects.requireNonNull(words);
        return (int) words.stream().filter(word -> word.startsWith("" + symbol)).count();
    }

    public static List<String> getWordsContainingSubstring(List<String> words, String substring) {
        Objects.requireNonNull(words);
        return words.stream().filter(word -> word.contains(substring)).toList();
    }

    public static List<String> sortByWordsLength(List<String> words) {
        Objects.requireNonNull(words);
        return words.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkPredicate(List<Integer> numbers, Predicate<Integer> predicate) {
        Objects.requireNonNull(numbers);
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinWithLowerBound(List<Integer> numbers, int lowerBound) {
        Objects.requireNonNull(numbers);
        return numbers.stream().filter(number -> number > lowerBound).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> getWordsLength(List<String> words) {
        Objects.requireNonNull(words);
        return words.stream().map(String::length).toList();
    }
}
