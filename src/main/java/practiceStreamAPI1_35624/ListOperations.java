package practiceStreamAPI1_35624;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    public static int countStringsStartingWith(@NonNull List<String> words, char ch) {
        return (int) words.stream()
                .filter(word -> !word.isEmpty() && word.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> words, String substring) {
        return words.stream()
                .filter(word -> !word.isEmpty() && word.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }


}
