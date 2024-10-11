package school.faang.train_streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class MethodsStreams {

    public static int sumOfNumbers(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        return result.orElse(0);
    }

    public static int maxValue(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream().max(Comparator.naturalOrder());
        return result.orElse(0);
    }

    public static int findingTheOverage(List<Integer> numbers) {
        IntStream intStream = numbers.stream().mapToInt(num -> num);
        return (int) intStream.average().getAsDouble();
    }

    public static int counterStartWithSymbol(List<String> words, String symbol) {
        Predicate<String> isSymbol = word -> word.startsWith(symbol);
        return (int) words.stream().filter(isSymbol).count();
    }

    public static List<String> filterWords(List<String> words, String substring) {
        return words.stream().filter(word -> word.contains(substring)).toList();
    }

    public static List<String> sortListByLength(List<String> words) {
        return words.stream().sorted((a, b) -> a.length() - b.length()).toList();
    }

    public static Boolean checkingNumbersForValidity(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int smallestNumberAfterStartingValue(List<Integer> numbers, int startNumber) {
        return numbers.stream().filter(num -> num > startNumber).sorted().findFirst().orElse(startNumber);
    }

    public static List<Integer> stringsToIntegersLengths(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
