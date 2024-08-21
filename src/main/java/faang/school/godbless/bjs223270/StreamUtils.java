package faang.school.godbless.bjs223270;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StreamUtils {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow(NoSuchElementException::new);
    }

    public static double meanNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    public static long wordsCounter(List<String> words, String symbol) {
        return words
                .stream()
                .filter(w -> w.startsWith(symbol))
                .count();
    }

    public static List<String> wordsFilter(List<String> words, String line) {
        return words
                .stream()
                .filter(w -> w.contains(line))
                .toList();
    }

    public static List<String> wordsSorter(List<String> words) {
        return words
                .stream()
                .sorted((b, a) -> a.length() - b.length())
                .toList();
    }

    public static boolean wordsChecker(List<String> words, Predicate<String> predicate) {
        return words
                .stream()
                .allMatch(predicate);
    }

    public static int numbersFilteredMin(List<Integer> numbers, int number) {
        return numbers
                .stream()
                .filter(n -> n > number)
                .min(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> wordsConverter(List<String> words) {
        return words
                .stream()
                .map(String::length)
                .toList();
    }
}