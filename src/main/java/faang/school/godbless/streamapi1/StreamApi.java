package faang.school.godbless.streamapi1;

import java.util.List;
import java.util.function.Predicate;

import static java.lang.Integer.MIN_VALUE;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

public class StreamApi {
    public static int sum(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxElement(List<Integer> integerList) {
        return integerList.stream()
                .max(naturalOrder())
                .orElse(MIN_VALUE);
    }

    public static double average(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }


    public static long countStringsNumber(List<String> integerList, String beginFrom) {
        return integerList.stream()
                .filter(s -> s.startsWith(beginFrom))
                .count();
    }

    public static List<String> filterStringsByBeginWith(List<String> integerList, String substring) {
        return integerList.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> integerList) {
        return integerList.stream()
                .sorted(comparingInt(String::length))
                .toList();
    }

    public static boolean meetCondition(List<String> integerList, Predicate<String> condition) {
        return integerList.stream()
                .allMatch(condition);
    }

    public static int minElementGraterThanElement(List<Integer> integerList, int element) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .filter(i -> i > element)
                .min()
                .orElse(MIN_VALUE);
    }

    public static List<Integer> convertToListOfStringsLength(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
