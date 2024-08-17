package faang.school.godbless.stream.practice1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo);
    }

    public static double findAverage(List<Integer> numbers) {
        return sumEvenNumbers(numbers) / (double) numbers.size();
    }

    public static int countRowsStartingWith(List<String> strings, char symbol) {
        return (int) strings.stream().filter(str -> str.charAt(0) == symbol).count();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(String::compareTo).collect(Collectors.toList());
    }

    public <T> boolean allElementsSatisfyCondition(List<T> numbers, Predicate<T> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static Optional<Integer> findSmallestNumberGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream().filter(num -> num > target).min(Integer::compareTo);
    }

    public static List<Integer> getLengthsOfStrings(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

}
