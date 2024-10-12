package school.faang.streamOne;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).get();
    }

    static double findAverage(List<Integer> numbers) {
        return (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    static double countStringsStartingWith(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.startsWith(substring)).count();
    }

    static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    static boolean allMatchCondition(List<Integer> strings, Predicate<Integer> condition) {
        return strings.stream().allMatch(condition);
    }

    static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream().filter(n -> n > number).min(Integer::compare).get();
    }

    static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
