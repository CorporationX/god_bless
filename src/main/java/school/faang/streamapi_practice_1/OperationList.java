package school.faang.streamapi_practice_1;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Slf4j
public class OperationList {
    public static int sumEvenNumbers(List<Integer> numberList) {
        return numberList.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numberList) {
        return numberList.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Failed to find maximum number."));
    }

    public static double findAverage(List<Integer> numberList) {
        return numberList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty."));
    }

    public static long countStringsStartingWith(List<String> wordList, char character) {
        return wordList.stream()
                .filter(word -> word.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> wordList, String substring) {
        return wordList.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> wordList) {
        return wordList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isMatchingCondition(List<Integer> numberList, Predicate<Integer> condition) {
        return numberList.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numberList, int limit) {
        return numberList.stream()
                .filter(x -> x > limit)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No element greater than" + limit));
    }

    public static List<Integer> extractLengths(List<String> wordList) {
        return wordList.stream()
                .map(String::length)
                .toList();
    }
}