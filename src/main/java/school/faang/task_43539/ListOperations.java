package school.faang.task_43539;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public static int countStringsStartingWith(List<String> strings, Character a) {
        return (int) strings.stream().filter(s -> s.charAt(0) == a).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream().filter(s -> s.contains(str))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> num, int a) {
        return num.stream().filter(s -> s > a).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

}
