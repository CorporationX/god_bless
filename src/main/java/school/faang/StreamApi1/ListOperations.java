package school.faang.StreamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List " + "is empty"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average()
                .orElse(Double.NaN);
    }

    public static int countStringsStartingWith(List<String> list, char ch) {
        return (int) list.stream().filter(s -> s.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String string) {
        return list.stream().filter(s -> s.contains(string)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream().filter(i -> i > number).min(Comparator.naturalOrder()).orElseThrow(() -> new NoSuchElementException("No element greater than " + number));
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream().map(String::length).toList();
    }
}
