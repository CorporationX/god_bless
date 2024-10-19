package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();//filter(n -> n % 2 == 0).reduce(0, Integer::sum);
    }
    public static int findMax(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
    public static int countStringsStartingWith(List<String> strings, char firstChar) {
        return strings.stream().filter(str -> str.charAt(0) == firstChar).mapToInt(e -> 1).sum();
    }
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substr) {
        return strings.stream().filter(str -> str.contains(substr)).toList();
    }
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }
    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream().filter(n -> n > num).findFirst().orElse(0);
    }
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
