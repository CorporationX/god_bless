package school.faang.bjs2_88075;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    private static void printingListIsEmpty(List<?> empty) {
        if (empty.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    public static int findSumEvenNumbers(List<Integer> numbers) {
        printingListIsEmpty(numbers);

        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverageOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static long countStringsStartingWith(List<String> strings, char sign) {
        printingListIsEmpty(strings);

        return strings.stream()
                .filter(word -> word.charAt(0) == sign)
                .count();
    }

    public static List<String> filterStringsContainingSpecificSubstring(List<String> strings, String substring) {
        printingListIsEmpty(strings);

        return strings.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public static List<String> sortingByLength(List<String> strings) {
        printingListIsEmpty(strings);

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isSatisfyCertainElementsCondition(List<Integer> numbers, Predicate<Integer> condition) {
        printingListIsEmpty(numbers);

        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(n -> n > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is  empty"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        printingListIsEmpty(strings);

        return strings.stream()
                .map(String::length)
                .toList();
    }
}