package faang.school.godbless.BJS2_5653;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Stream {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (sumOfEvenNumbers, number) -> sumOfEvenNumbers + number);
    }

    public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max((number1, number2) -> number1.compareTo(number2));
    }

    public static OptionalDouble findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long CountWordsStartingWithSpecificSymbol(List<String> randomWords, String symbol) {
        return randomWords.stream()
                .filter(word -> word.startsWith(symbol))
                .count();
    }

    public static List<String> FindWordsWithSpecificSubstring(List<String> randomWords, String substring) {
        return randomWords.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> SortWordsByLength(List<String> randomWords) {
        return randomWords.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean hasANumber(List<String> randomWords) {
        return randomWords.stream()
                .anyMatch(string -> string.matches(".*\\d+.*"));
    }

    public static Optional<Integer> findSmallestNumberGreaterThanSpecificNumber(List<Integer> numbers, int specificNumber) {
        return numbers.stream()
                .filter(number -> number > specificNumber)
                .min((number1, number2) -> number1.compareTo(number2));
    }

    public static List<Integer> convertToLengths(List<String> randomWords) {
        return randomWords.stream()
                .map(String::length)
                .toList();
    }
}
