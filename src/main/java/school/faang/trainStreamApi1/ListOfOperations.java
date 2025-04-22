package school.faang.trainStreamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOfOperations {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long findLinesBeginWithSymbol(List<String> lines, char c) {
        return lines.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c).count();
    }

    public static List<String> findLinesContainSubstring(List<String> lines, String substring) {
        return lines.stream()
                .filter(s -> !s.isEmpty() && s.contains(substring)).toList();
    }

    public static List<String> sortLinesLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkListOnCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinNumber(List<Integer> numbers, Integer integer) {
        return numbers.stream()
                .filter(i -> i > integer)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static List<Integer> mapListOfLinesToListOfLengthLines(List<String> lines) {
        return lines.stream()
                .map(s -> s.length()).toList();
    }
}