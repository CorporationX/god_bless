package faang.school.godbless.sprint3.streamAPI.task2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI {

    public static int sumEvenNumber(List<Integer> numbers) {
        checkValidationList(numbers);
        return numbers.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Math::toIntExact)
                .sum();
    }

    public static Optional<Integer> maxNumber(List<Integer> numbers) {
        checkValidationList(numbers);
        return numbers.stream()
                .max(Comparator.comparingInt(x -> x));
    }

    public static double findAverageValueNumbers(List<Integer> numbers) {
        checkValidationList(numbers);
        return numbers.stream()
                .collect(Collectors.summarizingInt(x -> x))
                .getAverage();
    }

    public static List<String> findStringsStartWith(List<String> strings) {
        checkValidationList(strings);
        return strings.stream()
                .filter(x -> x.startsWith("W"))
                .collect(Collectors.toList());
    }

    public static List<String> findStringsContainsSubstring(List<String> strings) {
        checkValidationList(strings);
        return strings.stream()
                .filter(x -> x.contains("in"))
                .collect(Collectors.toList());
    }

    public static List<String> sortLength(List<String> strings) {
        checkValidationList(strings);
        return strings.stream()
                .sorted((x1, x2) -> x2.length() - x1.length())
                .collect(Collectors.toList());
    }

    public static List<String> checkCondition(List<String> strings) {
        checkValidationList(strings);
        return strings.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
    }

    public static int findSmallestNumberThanSpecifiedNumber(List<Integer> numbers, Integer specNumber) {
        checkValidationList(numbers);
        if (specNumber == null) {
            throw new IllegalArgumentException("specNumber null!");
        }
        return numbers.stream()
                .filter(x -> x > specNumber)
                .collect(Collectors.summarizingInt(x -> x))
                .getMin();
    }

    public static List<Integer> convertStringsToStringLength(List<String> strings) {
        checkValidationList(strings);
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    private static  <T> void checkValidationList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым или null");
        }
    }
}
