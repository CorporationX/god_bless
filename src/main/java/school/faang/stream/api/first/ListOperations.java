package school.faang.stream.api.first;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        OptionalInt maxOptional = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        return maxOptional.orElseThrow(() ->
                new IllegalArgumentException("в метод был передан пустой список"));
    }

    public static double findAverage(List<Integer> numbers) {
        OptionalDouble averageOptional = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return averageOptional.orElseThrow(() ->
                new IllegalArgumentException("в метод был передан пустой список"));
    }

    public static int countStringsStartingWith(List<String> strings, char prefix) {
        long count = strings.stream()
                .filter((str) -> str.charAt(0) == prefix)
                .count();
        if (count > Integer.MAX_VALUE) {
            throw new IllegalStateException("кол-во строк слишком велико");
        }
        return (int) count;
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter((str) -> str.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> matchCondition) {
        return numbers.stream()
                .allMatch(matchCondition);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, int min) {
        return numbers.stream()
                .sorted()
                .filter((num) -> num > min)
                .findFirst();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
