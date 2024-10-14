package org.example.service.trainingStream1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (num1, num2) -> num1 >= num2 ? num1 : num2);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static int countStringsStartingWith(List<String> words, char symbol) {
        return (int) words.stream()
                .filter(word -> word.startsWith(Character.toString(symbol)))
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

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(num -> num > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("not number greater than threshold"));
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
