package derschrank.sprint02.task08.bjstwo_47531;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (acc, add) -> acc + add);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max((o1, o2) -> o1 - o2)
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .average().orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        return (int) strings.stream()
                .filter(x -> x.startsWith(Character.toString(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String prefix) {
        return strings.stream()
                .filter(x -> x.contains(prefix))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((o1, o2) -> o1.length() - o2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int pivot) {
        return numbers.stream()
                .filter(x -> x > pivot)
                .min(Comparator.naturalOrder())
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(x -> x.length())
                .toList();
    }
}
