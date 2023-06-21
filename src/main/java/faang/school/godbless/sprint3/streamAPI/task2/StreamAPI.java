package faang.school.godbless.sprint3.streamAPI.task2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI {

    public static int sumEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Math::toIntExact)
                .sum();
    }

    public static Optional<Integer> maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(x -> x));
    }

    public static double findAverageValueNumbers(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.summarizingInt(x -> x))
                .getAverage();
    }

    public static List<String> findStringsStartWith(List<String> numbers) {
        return numbers.stream()
                .filter(x -> x.startsWith("W"))
                .collect(Collectors.toList());
    }

    public static List<String> findStringsContainsSubstring(List<String> numbers) {
        return numbers.stream()
                .filter(x -> x.contains("in"))
                .collect(Collectors.toList());
    }

    public static List<String> sortLength(List<String> numbers) {
        return numbers.stream()
                .sorted((x1, x2) -> x2.length() - x1.length())
                .collect(Collectors.toList());
    }

    public static List<String> checkCondition(List<String> numbers) {
        return numbers.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
    }

    public static int findSmallestNumberThanSpecifiedNumber(List<Integer> numbers, Integer specNumber) {
        return numbers.stream()
                .filter(x -> x > specNumber)
                .collect(Collectors.summarizingInt(x -> x))
                .getMin();
    }

    public static List<Integer> convertStringsToStringLength(List<String> numbers) {
        return numbers.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
