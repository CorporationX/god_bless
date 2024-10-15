package school.faang.BJS235640;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static int countStringsStartingWith(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(s -> s.charAt(0) == symbol)
                .mapToInt(s -> 1)
                .sum();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integerList, Predicate<Integer> integerPredicate) {
        return integerList.stream()
                .allMatch(integerPredicate);
    }

    public static int findMinGreaterThan(List<Integer> integerList, int min) {
        return integerList.stream().filter(integer -> integer > min).min(Comparator.naturalOrder()).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
