package trainingStreamApiFirst;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .reduce(0, (sumEvenNumbers, value) -> sumEvenNumbers + value);
    }

    public static Optional<Integer> findMax(List<Integer> list) {
        return list.stream()
                .max(((o1, o2) -> o1 - o2));
    }

    public static int findAverage(List<Integer> list) {
        return list.stream()
                .reduce(0, (sumAllElements, value) ->  sumAllElements + value) / list.size();
    }

    public static int countStringsStartingWith(List<String> list, char ch) {
        return (int) list.stream()
                .filter(value -> value.charAt(0) == ch).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        return list.stream().filter(value -> value.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted((o1, o2) -> o1.length() - o2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> list, int threshold) {
        return list.stream().filter(value -> value > threshold).min(Integer::compare);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
