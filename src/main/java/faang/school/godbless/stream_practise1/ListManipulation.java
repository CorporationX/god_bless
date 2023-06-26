package faang.school.godbless.stream_practise1;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ListManipulation {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxNumber(List<Integer> numbers) {
        OptionalInt maxNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();

        return maxNumber.orElse(0);
    }

    public static double getAverageNumber(List<Integer> numbers) {
        OptionalDouble averageNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        return averageNumber.orElse(0);
    }

    public static long getQuantityOfStringsStartWith(List<String> strings, String startWith) {
        return strings.stream()
                .filter(str -> str.startsWith(startWith))
                .count();
    }

    public static List<String> filterListBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortListByStringsLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static <T> boolean ifAllElementsPassTheCondition(List<T> list, Predicate<T> condition) {
        return list.stream().allMatch(condition);
    }

    public static int findSmallestNumberGreaterThan(int number, List<Integer> numbers) {
        OptionalInt min = numbers.stream()
                .filter(n -> n > number)
                .mapToInt(Integer::intValue)
                .min();

        return min.orElse(0);
    }

    public static List<Integer> transformStringsToItsLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
