package school.faang.BJS2_35685;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (a, b) -> a + b);
    }

    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).reduce(0, (a, b) -> a + b);
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max((a, b) -> a - b);
    }

    public static Optional<Double> findAverage(List<Integer> numbers) {
        return  numbers.stream().reduce((a, b) -> a + b).map(Integer::doubleValue).map(num -> num / numbers.size());
    }

    public static long countStringsStartingWith(List<String> strings, char ch){
        return strings.stream().filter(str -> str.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring){
        return strings.stream().filter(str -> str.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings){
        return strings.stream().sorted((str1, str2) -> str1.length() - str2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().filter(predicate).count() == numbers.size();
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, Integer lowerBound) {
        return numbers.stream().filter(n -> n > lowerBound).min(Integer::compare);
    }

    public static List<Integer> convertToLengths(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
}
