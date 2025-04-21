package school.faang.bjs270836;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (sum, number) -> sum + number);
    }

    public static int findMax(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream().max(Integer::compareTo);
        return result.orElseThrow(() -> new IllegalArgumentException("List is empty!"));
    }

    public static double findAverage(List<Integer> numbers) {
        int sum = sumOfEvenNumbers(numbers);
        long amount = numbers.stream().count();
        return (double) sum / amount;
    }

    public static long filterStringsContainingSubstring(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.contains(String.valueOf(symbol))).count();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(number1 -> number1 > number).min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No such element"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}